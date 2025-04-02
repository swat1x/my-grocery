package my.grocery.storageservice.exception.type.balance;

import my.grocery.storageservice.exception.ErrorCode;
import my.grocery.util.exception.ServiceException;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class    BalanceNotFoundException extends ServiceException {

    public BalanceNotFoundException(UUID balanceId) {
        super(HttpStatus.NOT_FOUND, ErrorCode.POSITION_NOT_FOUND.name(),
                "Баланс с указанным айди не найден: " + balanceId);
    }

}
