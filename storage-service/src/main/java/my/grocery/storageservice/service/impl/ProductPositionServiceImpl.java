package my.grocery.storageservice.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import my.grocery.storageservice.api.dto.ProductPositionDTO;
import my.grocery.storageservice.data.ProductPositionInnerDTO;
import my.grocery.storageservice.exception.type.position.DuplicateDisplayNameException;
import my.grocery.storageservice.exception.type.position.PositionNotFoundException;
import my.grocery.storageservice.repository.ProductPositionRepository;
import my.grocery.storageservice.service.ProductPositionService;
import my.grocery.storageservice.mapper.ProductPositionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductPositionServiceImpl implements ProductPositionService {

    ProductPositionMapper positionMapper;
    ProductPositionRepository positionRepository;

    @Override
    public List<ProductPositionInnerDTO> getActivePositions() {
        var positions = positionRepository.getAllActivePositions();
        return positionMapper.toInner(positions);
    }

    @Override
    public ProductPositionInnerDTO getPositionById(UUID positionId) {
        return findPositionById(positionId).orElseThrow(() -> new PositionNotFoundException(positionId));
    }

    @Override
    public Optional<ProductPositionInnerDTO> findPositionById(UUID positionId) {
        return positionRepository.findById(positionId)
                .map(positionMapper::toInner);
    }

    @Override
    public ProductPositionInnerDTO addPosition(ProductPositionDTO positionDTO) throws DuplicateDisplayNameException {
        Objects.requireNonNull(positionDTO.getDisplayName(), "Display name cannot be null");

        var sameDisplayNameProduct = positionRepository.getProductPositionByDisplayName(positionDTO.getDisplayName());

        if (sameDisplayNameProduct != null)
            throw new DuplicateDisplayNameException(positionDTO.getDisplayName(), sameDisplayNameProduct.getId());

        var position = positionMapper.fromDTOSafe(positionDTO);

        return savePosition(position);
    }

    @Override
    public ProductPositionInnerDTO patchPosition(UUID positionId, ProductPositionDTO positionDTO) throws PositionNotFoundException {
        var position = getPositionById(positionId);
        position = positionMapper.merge(positionDTO, position);
        return savePosition(position);
    }

    private ProductPositionInnerDTO savePosition(ProductPositionInnerDTO balance) {
        var mappedEntity = positionMapper.toEntityFromInner(balance);
        var savedEntity = positionRepository.save(mappedEntity);
        return positionMapper.toInner(savedEntity);
    }
}
