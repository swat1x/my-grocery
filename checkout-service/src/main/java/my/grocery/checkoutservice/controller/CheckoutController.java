package my.grocery.checkoutservice.controller;

import my.grocery.storageservice.api.dto.ProductBalanceDTO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface CheckoutController {

    @GetMapping(path = "/active-balances", produces = {"application/json"})
    List<ProductBalanceDTO> getActiveBalances();

}
