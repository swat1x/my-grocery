package my.grocery.storageservice.data;

import lombok.*;
import lombok.experimental.FieldDefaults;
import my.grocery.storageservice.api.dto.ProductPositionDTO;

import java.util.UUID;

@Getter
@Setter

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class ProductBalanceInnerDto {

    UUID id;

    ProductPositionDTO position;

    double quantity;

    public void increaseQuantity(double quantity) {
        setQuantity(getQuantity() + quantity);
    }

    public void decreaseQuantity(double quantity) {
        setQuantity(getQuantity() - quantity);
    }

}
