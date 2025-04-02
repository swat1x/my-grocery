package my.grocery.checkoutservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Table(name = "checkouts")

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    UUID id;

    @Column(name = "position_id")
    UUID positionId;

    @JoinColumn(name = "payment_id")
    @OneToOne(cascade = CascadeType.ALL)
    PaymentEntity payment;

    @Column(name = "position_amount")
    double positionAmount;

}
