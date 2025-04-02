package my.grocery.storageservice.service;

import my.grocery.storageservice.data.ProductBalanceInnerDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductBalanceService {

    List<ProductBalanceInnerDto> getActiveBalances();

    ProductBalanceInnerDto getBalanceById(UUID balanceId);

    ProductBalanceInnerDto getBalanceByProductId(UUID productId);

    Optional<ProductBalanceInnerDto> findBalanceById(UUID balanceId);

    ProductBalanceInnerDto setupBalance(UUID balanceId, double balanceValue);

    ProductBalanceInnerDto depositBalance(UUID balanceId, double depositValue);

    ProductBalanceInnerDto withdrawBalance(UUID balanceId, double withdrawValue);

}
