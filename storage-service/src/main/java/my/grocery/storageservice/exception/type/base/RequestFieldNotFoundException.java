package my.grocery.storageservice.exception.type.base;

import my.grocery.storageservice.exception.ErrorCode;
import my.grocery.util.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class RequestFieldNotFoundException extends ServiceException {

    public RequestFieldNotFoundException(String fieldName) {
        super(HttpStatus.BAD_REQUEST, ErrorCode.REQUEST_ERROR.name(),
                "В теле запроса требуется обязательное поле: " + fieldName);
    }

}
