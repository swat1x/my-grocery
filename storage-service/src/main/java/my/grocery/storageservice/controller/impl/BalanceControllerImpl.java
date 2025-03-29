package my.grocery.storageservice.controller.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import my.grocery.storageservice.api.dto.ProductBalanceDTO;
import my.grocery.storageservice.controller.BalanceController;
import my.grocery.storageservice.entity.ProductBalanceEntity;
import my.grocery.storageservice.service.ProductBalanceService;
import my.grocery.storageservice.mapper.ProductBalanceMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BalanceControllerImpl implements BalanceController {

    ProductBalanceMapper balanceMapper;
    ProductBalanceService balanceService;

    @Override
    public List<ProductBalanceDTO> getActiveBalances() {
        var balanceList = balanceService.getActiveBalances();
        return balanceMapper.toDTO(balanceList);
    }

    @Override
    public ProductBalanceDTO setBalance(UUID productId, int amount) {
        var newBalance = balanceService.setupBalance(productId, amount);
        return balanceMapper.toDTO(newBalance);
    }

    @Override
    public ProductBalanceDTO decreaseBalance(UUID productId, int amount) {
        var newBalance = balanceService.withdrawBalance(productId, amount);
        return balanceMapper.toDTO(newBalance);
    }

    @Override
    public ProductBalanceDTO increaseBalance(UUID productId, int amount) {
        var newBalance = balanceService.depositBalance(productId, amount);
        return balanceMapper.toDTO(newBalance);
    }

}
