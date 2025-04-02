package my.grocery.storageservice.config;

import my.grocery.storageservice.mapper.ProductBalanceMapper;
import my.grocery.storageservice.mapper.ProductPositionMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ProductBalanceMapper balanceMapper() {
        return Mappers.getMapper(ProductBalanceMapper.class);
    }

    @Bean
    public ProductPositionMapper positionMapper() {
        return Mappers.getMapper(ProductPositionMapper.class);
    }

}