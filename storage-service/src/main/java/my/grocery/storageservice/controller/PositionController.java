package my.grocery.storageservice.controller;

import my.grocery.storageservice.api.dto.ProductPositionDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/storage/position")
public interface PositionController {

    @GetMapping("/active-positions")
    List<ProductPositionDTO> getActivePositions();

    @PostMapping("/add")
    ProductPositionDTO addPosition(@RequestBody ProductPositionDTO productPosition);

    @PatchMapping("/edit/{positionId}")
    ProductPositionDTO editPosition(@PathVariable UUID positionId, @RequestBody ProductPositionDTO productPosition);

}
