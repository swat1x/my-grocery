package my.grocery.storageservice.exception.type.position;

import my.grocery.storageservice.exception.ErrorCode;
import my.grocery.storageservice.exception.ServiceException;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class PositionNotFoundException extends ServiceException {

    public PositionNotFoundException(UUID productId) {
        super(HttpStatus.NOT_FOUND, ErrorCode.POSITION_NOT_FOUND,
                "Товар с таким айди не найден: " + productId);
    }

}
