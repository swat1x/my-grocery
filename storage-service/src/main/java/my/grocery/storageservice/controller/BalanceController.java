package my.grocery.storageservice.controller;

import my.grocery.storageservice.api.dto.ProductBalanceDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/storage/balance")
public interface BalanceController {

    @GetMapping("/active-balances")
    List<ProductBalanceDTO> getActiveBalances();

    @PostMapping("/set/{productId}")
    ProductBalanceDTO setBalance(@PathVariable("productId") UUID productId, @RequestParam("amount") int amount);

    @PostMapping("/decrease/{productId}")
    ProductBalanceDTO decreaseBalance(@PathVariable("productId") UUID productId, @RequestParam("amount") int amount);

    @PostMapping("/increase/{productId}")
    ProductBalanceDTO increaseBalance(@PathVariable("productId") UUID productId, @RequestParam("amount") int amount);

}
