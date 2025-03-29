package my.grocery.storageservice.repository;

import my.grocery.storageservice.entity.ProductPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductPositionRepository extends JpaRepository<ProductPositionEntity, UUID> {

    ProductPositionEntity getProductPositionByDisplayName(String displayName);

    @Query("select p from ProductPositionEntity p where p.active = true")
    List<ProductPositionEntity> getAllActivePositions();

}
