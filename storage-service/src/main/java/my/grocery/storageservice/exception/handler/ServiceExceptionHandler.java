package my.grocery.storageservice.exception.handler;

import my.grocery.storageservice.exception.ErrorCode;
import my.grocery.storageservice.exception.ServiceException;
import my.grocery.storageservice.exception.dto.ServiceExceptionDto;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<Object> handleServiceException(final ServiceException exception) {
        return buildErrorResponse(exception);
    }

    /* STANDARD EXCEPTIONS */

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return buildErrorResponse(
                (HttpStatus) status,
                ex.getMessage()
        );
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return buildErrorResponse(
                HttpStatus.valueOf(status.value()),
                ex.getMessage()
        );
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return buildErrorResponse(
                HttpStatus.valueOf(status.value()),
                "Попытка форматирования типа " + (ex.getValue() == null ? null : ex.getValue().getClass().getSimpleName()) + " в " + ex.getRequiredType().getSimpleName()
                        + " значения: " + ex.getValue()
        );
    }

    public ResponseEntity<Object> buildErrorResponse(HttpStatus status,
                                                     ErrorCode errorCode,
                                                     String message) {
        var body = new ServiceExceptionDto(
                status.value(),
                status,
                errorCode,
                message
        );
        return new ResponseEntity<>(body, status);
    }


    public ResponseEntity<Object> buildErrorResponse(ServiceException serviceException) {
        return buildErrorResponse(serviceException.getStatus(), serviceException.getErrorCode(), serviceException.getMessage());
    }

    public ResponseEntity<Object> buildErrorResponse(HttpStatus status,
                                                     String message) {
        return buildErrorResponse(status, ErrorCode.REQUEST_ERROR, message);
    }
}
