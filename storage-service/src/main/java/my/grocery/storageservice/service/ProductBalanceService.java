package my.grocery.storageservice.service;

import my.grocery.storageservice.data.ProductBalanceInnerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductBalanceService {

    List<ProductBalanceInnerDTO> getActiveBalances();

    ProductBalanceInnerDTO getBalanceById(UUID balanceId);

    ProductBalanceInnerDTO getBalanceByProductId(UUID productId);

    Optional<ProductBalanceInnerDTO> findBalanceById(UUID balanceId);

    ProductBalanceInnerDTO setupBalance(UUID balanceId, double balanceValue);

    ProductBalanceInnerDTO depositBalance(UUID balanceId, double depositValue);

    ProductBalanceInnerDTO withdrawBalance(UUID balanceId, double withdrawValue);

}
