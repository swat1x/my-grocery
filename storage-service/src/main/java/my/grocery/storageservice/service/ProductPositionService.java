package my.grocery.storageservice.service;

import my.grocery.storageservice.api.dto.ProductPositionDTO;
import my.grocery.storageservice.data.ProductPositionInnerDto;
import my.grocery.storageservice.exception.type.position.DuplicateDisplayNameException;
import my.grocery.storageservice.exception.type.position.PositionNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductPositionService {

    List<ProductPositionInnerDto> getActivePositions();

    ProductPositionInnerDto getPositionById(UUID positionId);

    Optional<ProductPositionInnerDto> findPositionById(UUID positionId);

    ProductPositionInnerDto addPosition(ProductPositionDTO positionDTO) throws DuplicateDisplayNameException;

    ProductPositionInnerDto patchPosition(UUID positionId, ProductPositionDTO positionDTO) throws PositionNotFoundException;

}
