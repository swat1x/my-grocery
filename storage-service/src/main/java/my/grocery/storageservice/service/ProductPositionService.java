package my.grocery.storageservice.service;

import my.grocery.storageservice.api.dto.ProductPositionDTO;
import my.grocery.storageservice.data.ProductPositionInnerDTO;
import my.grocery.storageservice.exception.type.position.DuplicateDisplayNameException;
import my.grocery.storageservice.exception.type.position.PositionNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductPositionService {

    List<ProductPositionInnerDTO> getActivePositions();

    ProductPositionInnerDTO getPositionById(UUID positionId);

    Optional<ProductPositionInnerDTO> findPositionById(UUID positionId);

    ProductPositionInnerDTO addPosition(ProductPositionDTO positionDTO) throws DuplicateDisplayNameException;

    ProductPositionInnerDTO patchPosition(UUID positionId, ProductPositionDTO positionDTO) throws PositionNotFoundException;

}
