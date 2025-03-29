package my.grocery.storageservice.controller.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import my.grocery.storageservice.api.dto.ProductPositionDTO;
import my.grocery.storageservice.controller.PositionController;
import my.grocery.storageservice.mapper.ProductPositionMapper;
import my.grocery.storageservice.service.ProductPositionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PositionControllerImpl implements PositionController {

    ProductPositionMapper positionMapper;
    ProductPositionService positionService;

    @Override
    public List<ProductPositionDTO> getActivePositions() {
        return positionMapper.toDTO(positionService.getActivePositions());
    }

    @Override
    public ProductPositionDTO addPosition(ProductPositionDTO productPosition) {
        return positionMapper.toDTO(positionService.addPosition(productPosition));
    }

    @Override
    public ProductPositionDTO editPosition(UUID positionId, ProductPositionDTO productPosition) {
        return positionMapper.toDTO(positionService.patchPosition(positionId, productPosition));
    }

}
