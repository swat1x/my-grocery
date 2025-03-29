package my.grocery.storageservice.repository;

import my.grocery.storageservice.entity.ProductBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductBalanceRepository extends JpaRepository<ProductBalanceEntity, UUID> {

    @Query("select b from ProductBalanceEntity b where b.quantity > 0")
    List<ProductBalanceEntity> getAllActiveBalances();

    @Query("select b from ProductBalanceEntity  b where b.position.id = :positionId")
    Optional<ProductBalanceEntity> findBalanceByPositionId(UUID positionId);

}
