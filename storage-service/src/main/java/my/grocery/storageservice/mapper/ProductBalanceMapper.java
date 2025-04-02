package my.grocery.storageservice.mapper;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import my.grocery.storageservice.api.dto.ProductBalanceDTO;
import my.grocery.storageservice.api.dto.ProductPositionDTO;
import my.grocery.storageservice.data.ProductBalanceInnerDto;
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

    public abstract ProductBalanceInnerDto toInner(ProductBalanceEntity productBalance);

    public abstract List<ProductBalanceInnerDto> toInner(List<ProductBalanceEntity> productBalances);

    /* TO ENTITY */

    public abstract ProductBalanceEntity toEntityFromInner(ProductBalanceInnerDto target);

    public abstract List<ProductBalanceEntity> toEntityFromInner(List<ProductBalanceInnerDto> innerDTO);

    /* TO DTO */

    public abstract List<ProductBalanceDTO> toDTO(List<ProductBalanceInnerDto> productBalanceList);

    public abstract ProductBalanceDTO toDTO(ProductBalanceInnerDto productBalance);

    public abstract ProductBalanceInnerDto fromDTO(ProductBalanceDTO dto);

    @Mapping(target = "id", ignore = true)
    public abstract ProductBalanceInnerDto fromDTOSafe(ProductBalanceDTO dto);

    /* MERGE */

    @Mapping(target = "id", ignore = true)
    public abstract ProductBalanceInnerDto merge(ProductBalanceDTO dto, @MappingTarget ProductBalanceInnerDto target);

}
