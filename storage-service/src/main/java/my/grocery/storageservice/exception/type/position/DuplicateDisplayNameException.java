package my.grocery.storageservice.exception.type.position;

import my.grocery.storageservice.exception.ErrorCode;
import my.grocery.util.exception.ServiceException;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class DuplicateDisplayNameException extends ServiceException {

    public DuplicateDisplayNameException(String target, UUID ownerProduct) {
        super(HttpStatus.CONFLICT, ErrorCode.DUPLICATE_DISPLAY_NAME.name(),
                "Имя товара " + target + " уже использовано в продукте " + ownerProduct);
    }

}
