package my.grocery.storageservice;

import my.grocery.storageservice.api.dto.ProductPositionDTO;
import my.grocery.storageservice.mapper.ProductBalanceMapper;
import my.grocery.storageservice.mapper.ProductPositionMapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@MapperConfig(componentModel = "spring")
@Configuration
public class MapperSpringConfig {

    @Bean
    public ProductBalanceMapper balanceMapper() {
        return Mappers.getMapper(ProductBalanceMapper.class);
    }

    @Bean
    public ProductPositionMapper positionMapper() {
        return Mappers.getMapper(ProductPositionMapper.class);
    }

}