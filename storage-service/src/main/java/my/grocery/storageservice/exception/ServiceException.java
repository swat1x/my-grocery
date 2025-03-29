package my.grocery.storageservice.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ServiceException extends RuntimeException {

    ErrorCode errorCode;
    HttpStatus status;

    public ServiceException(HttpStatus status, ErrorCode errorCode, String message) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }

    public ServiceException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.errorCode = ErrorCode.UNNAMED_ERROR;
    }

    public ServiceException(HttpStatus status) {
        super("Unknown exception");
        this.status = status;
        this.errorCode = ErrorCode.UNNAMED_ERROR;
    }



}
