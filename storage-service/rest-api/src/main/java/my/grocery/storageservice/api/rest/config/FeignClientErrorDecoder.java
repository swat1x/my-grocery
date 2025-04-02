package my.grocery.storageservice.api.rest.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import my.grocery.util.exception.ServiceException;
import my.grocery.util.exception.dto.ServiceExceptionDto;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class FeignClientErrorDecoder implements ErrorDecoder {

    ErrorDecoder defaultErrorDecoder = new Default();
    ObjectMapper objectMapper;

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() != HttpStatus.OK.value()) {
            String responseBody = getResponseBody(response);
//            String errorMessage = String.format("Feign client error: Status %d, Body: %s",
//                response.status(), responseBody);

            ServiceExceptionDto dto;
            try {
                dto = objectMapper.readValue(responseBody, ServiceExceptionDto.class);
            } catch (JsonProcessingException e) {
                throw new ServiceException(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "CANT_READ_EXTERNAL_SERVICE_EXCEPTION",
                        "Exception: " + e.getMessage()
                );
            }
            throw new ServiceException(
                    dto.getStatus(),
                    dto.getErrorCode(),
                    dto.getMessage()
            );
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }

    private String getResponseBody(Response response) {
        try {
            if (response.body() != null) {
                return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            return "Failed to read response body: " + e.getMessage();
        }
        return "Empty response body";
    }
}