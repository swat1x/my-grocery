package my.grocery.storageservice.exception.type.balance;

import my.grocery.storageservice.exception.ErrorCode;
import my.grocery.storageservice.exception.ServiceException;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class BalanceNotPresentException extends ServiceException {

    public BalanceNotPresentException(UUID productId) {
        super(HttpStatus.NOT_FOUND, ErrorCode.POSITION_NOT_FOUND,
                "Баланс для товара с таким айди не установлен: " + productId);
    }

}
