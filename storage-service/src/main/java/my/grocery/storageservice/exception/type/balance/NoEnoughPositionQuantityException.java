package my.grocery.storageservice.exception.type.balance;

import my.grocery.storageservice.exception.ErrorCode;
import my.grocery.storageservice.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class NoEnoughPositionQuantityException extends ServiceException {

    public NoEnoughPositionQuantityException(double actualQuantity) {
        super(HttpStatus.CONFLICT, ErrorCode.NO_ENOUGH_POSITION,
                "Нет товара в таком количестве. Текущее количество данного товара: " + actualQuantity);
    }

}
