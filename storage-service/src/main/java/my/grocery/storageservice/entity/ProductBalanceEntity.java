package my.grocery.storageservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Table(name = "product_balance")

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ProductBalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "balance_id")
    UUID id;

    @JoinColumn(name = "position_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    ProductPositionEntity position;

    @Column(name = "product_quantity", nullable = false)
    double quantity;

}
