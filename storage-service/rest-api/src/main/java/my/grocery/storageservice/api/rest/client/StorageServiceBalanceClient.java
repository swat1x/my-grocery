package my.grocery.storageservice.api.rest.client;

import my.grocery.storageservice.api.dto.ProductBalanceDTO;
import my.grocery.storageservice.api.rest.config.StorageServiceFeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(
        value = "storage-service-balance-v1",
        url = "${my-grocery.storage-host}/api/storage/balance",
        configuration = StorageServiceFeignClientConfig.class
)
public interface StorageServiceBalanceClient {

    @GetMapping(path = "/active-balances", produces = {"application/json"})
    List<ProductBalanceDTO> getActiveBalances();

    @PostMapping(path = "/set/{productId}", produces = {"application/json"})
    ProductBalanceDTO setBalance(@PathVariable("productId") UUID productId, @RequestParam("amount") int amount);

    @PostMapping(path = "/decrease/{productId}", produces = {"application/json"})
    ProductBalanceDTO decreaseBalance(@PathVariable("productId") UUID productId, @RequestParam("amount") int amount);

    @PostMapping(path = "/increase/{productId}", produces = {"application/json"})
    ProductBalanceDTO increaseBalance(@PathVariable("productId") UUID productId, @RequestParam("amount") int amount);


}
