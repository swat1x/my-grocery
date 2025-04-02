package my.grocery.checkoutservice.repository;

import my.grocery.checkoutservice.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckoutRepository extends JpaRepository<CheckoutEntity, UUID> {
}
