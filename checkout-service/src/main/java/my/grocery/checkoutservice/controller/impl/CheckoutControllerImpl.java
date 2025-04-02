package my.grocery.checkoutservice.controller.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import my.grocery.checkoutservice.controller.CheckoutController;
import my.grocery.storageservice.api.rest.client.StorageServiceBalanceClient;
import my.grocery.storageservice.api.dto.ProductBalanceDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor

@RequestMapping("/api/checkout/base")
public class CheckoutControllerImpl implements CheckoutController {

    StorageServiceBalanceClient balanceClient;

    @Override
    public List<ProductBalanceDTO> getActiveBalances() {
        return balanceClient.getActiveBalances();
    }

}
