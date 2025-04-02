package my.grocery.checkoutservice.config;


import my.grocery.storageservice.api.rest.config.StorageServiceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(StorageServiceConfig.class)
public class CheckoutServiceConfig {

}
