package my.grocery.storageservice.exception.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import my.grocery.storageservice.exception.ErrorCode;
import org.springframework.http.HttpStatus;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ServiceExceptionDto {

    int code;

    HttpStatus status;

    ErrorCode errorCode;

    String message;

}
