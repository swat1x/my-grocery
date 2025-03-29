package my.grocery.storageservice.service.impl;

import jakarta.persistence.LockModeType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import my.grocery.storageservice.data.ProductBalanceInnerDTO;
import my.grocery.storageservice.exception.type.balance.BalanceNotFoundException;
import my.grocery.storageservice.exception.type.balance.BalanceNotPresentException;
import my.grocery.storageservice.repository.ProductBalanceRepository;
import my.grocery.storageservice.service.ProductBalanceService;
import my.grocery.storageservice.service.ProductPositionService;
import my.grocery.storageservice.mapper.ProductBalanceMapper;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductBalanceServiceImpl implements ProductBalanceService {

    ProductBalanceMapper balanceMapper;
    ProductBalanceRepository balanceRepository;

    ProductPositionService positionService;

    @Override
    public List<ProductBalanceInnerDTO> getActiveBalances() {
        var balances = balanceRepository.getAllActiveBalances();
        return balanceMapper.toInner(balances);
    }

    @Override
    public ProductBalanceInnerDTO getBalanceById(UUID balanceId) {
        return balanceRepository.findById(balanceId)
                .map(balanceMapper::toInner)
                .orElseThrow(() -> new BalanceNotFoundException(balanceId));
    }

    @Override
    public ProductBalanceInnerDTO getBalanceByProductId(UUID productId) {
        return findBalanceById(productId).orElseThrow(() -> new BalanceNotPresentException(productId));
    }

    @Override
    public Optional<ProductBalanceInnerDTO> findBalanceById(UUID balanceId) {
        return balanceRepository.findById(balanceId).map(balanceMapper::toInner);
    }

    @Override
    @Lock(LockModeType.WRITE)
    public ProductBalanceInnerDTO setupBalance(UUID balanceId, double balanceValue) {
        var balance = getBalanceById(balanceId);
        balance.setQuantity(balanceValue);

        return saveBalance(balance);
    }

    @Override
    @Lock(LockModeType.WRITE)
    public ProductBalanceInnerDTO depositBalance(UUID balanceId, double depositValue) {
        var balance = getBalanceById(balanceId);
        balance.increaseQuantity(depositValue);

        return saveBalance(balance);
    }

    @Override
    @Lock(LockModeType.WRITE)
    public ProductBalanceInnerDTO withdrawBalance(UUID balanceId, double withdrawValue) {
        var balance = getBalanceById(balanceId);
        balance.decreaseQuantity(withdrawValue);

        return saveBalance(balance);
    }

    private ProductBalanceInnerDTO saveBalance(ProductBalanceInnerDTO balance) {
        var mappedEntity = balanceMapper.toEntityFromInner(balance);
        var savedEntity = balanceRepository.save(mappedEntity);
        return balanceMapper.toInner(savedEntity);
    }

}
