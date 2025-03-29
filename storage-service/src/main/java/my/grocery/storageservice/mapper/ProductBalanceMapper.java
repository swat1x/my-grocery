package my.grocery.storageservice.mapper;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import my.grocery.storageservice.api.dto.ProductBalanceDTO;
import my.grocery.storageservice.api.dto.ProductPositionDTO;
import my.grocery.storageservice.data.ProductBalanceInnerDTO;
import my.grocery.storageservice.entity.ProductBalanceEntity;
import my.grocery.storageservice.entity.ProductPositionEntity;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@ConditionalOnProperty(prefix = "api.external-data", name = "enabled", havingValue = "true", matchIfMissing = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
public abstract class ProductBalanceMapper {

    @Autowired
    ProductPositionMapper positionMapper;

    public ProductPositionEntity map(ProductPositionDTO value) {
        return positionMapper.toEntityFromDto(value);
    }

    /* TO INNER */

    public abstract ProductBalanceInnerDTO toInner(ProductBalanceEntity productBalance);

    public abstract List<ProductBalanceInnerDTO> toInner(List<ProductBalanceEntity> productBalances);

    /* TO ENTITY */

    public abstract ProductBalanceEntity toEntityFromInner(ProductBalanceInnerDTO target);

    public abstract List<ProductBalanceEntity> toEntityFromInner(List<ProductBalanceInnerDTO> innerDTO);

    /* TO DTO */

    public abstract List<ProductBalanceDTO> toDTO(List<ProductBalanceInnerDTO> productBalanceList);

    public abstract ProductBalanceDTO toDTO(ProductBalanceInnerDTO productBalance);

    public abstract ProductBalanceInnerDTO fromDTO(ProductBalanceDTO dto);

    @Mapping(target = "id", ignore = true)
    public abstract ProductBalanceInnerDTO fromDTOSafe(ProductBalanceDTO dto);

    /* MERGE */

    @Mapping(target = "id", ignore = true)
    public abstract ProductBalanceInnerDTO merge(ProductBalanceDTO dto, @MappingTarget ProductBalanceInnerDTO target);

}
