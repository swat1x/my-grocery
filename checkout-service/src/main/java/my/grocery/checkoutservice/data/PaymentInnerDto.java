package my.grocery.checkoutservice.data;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import my.grocery.storageservice.api.dto.ProductPositionDTO;

import java.util.UUID;

@Getter
@Setter

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInnerDto {

    UUID id;

    String signature;

    double sum;

    String currency;

    long timestamp;

}
