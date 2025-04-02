package my.grocery.storageservice.mapper;

import my.grocery.storageservice.api.dto.ProductPositionDTO;
import my.grocery.storageservice.data.ProductPositionInnerDto;
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

    public abstract ProductPositionInnerDto toInner(ProductPositionEntity productPosition);

    public abstract List<ProductPositionInnerDto> toInner(List<ProductPositionEntity> productPositions);

    /* TO ENTITY */

    public abstract ProductPositionEntity toEntityFromDto(ProductPositionDTO dto);

    public abstract List<ProductPositionEntity> toEntityFromDto(List<ProductPositionDTO> dto);

    public abstract ProductPositionEntity toEntityFromInner(ProductPositionInnerDto innerDTO);

    public abstract List<ProductPositionEntity> toEntityFromInner(List<ProductPositionInnerDto> innerDTO);

    /* TO DTO */

    public abstract List<ProductPositionDTO> toDTO(List<ProductPositionInnerDto> productPositionList);

    public abstract ProductPositionDTO toDTO(ProductPositionInnerDto productPosition);

    public abstract ProductPositionInnerDto fromDTO(ProductPositionDTO dto);

    @Mapping(target = "id", ignore = true)
    public abstract ProductPositionInnerDto fromDTOSafe(ProductPositionDTO dto);

    /* MERGE */

    @Mapping(target = "id", ignore = true)
    public abstract ProductPositionInnerDto merge(ProductPositionDTO dto, @MappingTarget ProductPositionInnerDto entity);


}
