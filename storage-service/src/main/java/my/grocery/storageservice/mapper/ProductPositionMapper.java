package my.grocery.storageservice.mapper;

import my.grocery.storageservice.api.dto.ProductPositionDTO;
import my.grocery.storageservice.data.ProductPositionInnerDTO;
import my.grocery.storageservice.entity.ProductPositionEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductPositionMapper {

//    @Bean
//    static ProductPositionMapper mapperBean() {
//        return Mappers.getMapper(ProductPositionMapper.class);
//    }

    /* TO INNER */

    public abstract ProductPositionInnerDTO toInner(ProductPositionEntity productPosition);

    public abstract List<ProductPositionInnerDTO> toInner(List<ProductPositionEntity> productPositions);

    /* TO ENTITY */

    public abstract ProductPositionEntity toEntityFromDto(ProductPositionDTO dto);

    public abstract List<ProductPositionEntity> toEntityFromDto(List<ProductPositionDTO> dto);

    public abstract ProductPositionEntity toEntityFromInner(ProductPositionInnerDTO innerDTO);

    public abstract List<ProductPositionEntity> toEntityFromInner(List<ProductPositionInnerDTO> innerDTO);

    /* TO DTO */

    public abstract List<ProductPositionDTO> toDTO(List<ProductPositionInnerDTO> productPositionList);

    public abstract ProductPositionDTO toDTO(ProductPositionInnerDTO productPosition);

    public abstract ProductPositionInnerDTO fromDTO(ProductPositionDTO dto);

    @Mapping(target = "id", ignore = true)
    public abstract ProductPositionInnerDTO fromDTOSafe(ProductPositionDTO dto);

    /* MERGE */

    @Mapping(target = "id", ignore = true)
    public abstract ProductPositionInnerDTO merge(ProductPositionDTO dto, @MappingTarget ProductPositionInnerDTO entity);


}
