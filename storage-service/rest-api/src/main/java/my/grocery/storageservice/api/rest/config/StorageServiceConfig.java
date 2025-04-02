package my.grocery.storageservice.api.rest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация API для взаимодействия с project-service
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {
    "my.grocery.storageservice.api.rest"
})
@EnableFeignClients(basePackages = {
    "my.grocery.storageservice.api.rest.client"
})
public class StorageServiceConfig {
}
