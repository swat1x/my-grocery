package my.grocery.storageservice.api.rest.client;

import my.grocery.storageservice.api.rest.config.StorageServiceFeignClientConfig;
import my.grocery.storageservice.api.dto.ProductPositionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(
        value = "storage-service-balance-v1",
        url = "${my-grocery.storage-host}/api/storage/position",
        configuration = StorageServiceFeignClientConfig.class
)
public interface StorageServicePositionClient {

    @GetMapping(path = "/active-positions", produces = {"application/json"})
    List<ProductPositionDTO> getActivePositions();

    @PostMapping(path = "/add", produces = {"application/json"})
    ProductPositionDTO addPosition(@RequestBody ProductPositionDTO productPosition);

    @PatchMapping(path = "/edit/{positionId}", produces = {"application/json"})
    ProductPositionDTO editPosition(@PathVariable UUID positionId, @RequestBody ProductPositionDTO productPosition);


}
