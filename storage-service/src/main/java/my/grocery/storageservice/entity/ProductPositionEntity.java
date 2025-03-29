package my.grocery.storageservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Table(name = "product_position")

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ProductPositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    UUID id;

    @Column(name = "display_name", nullable = false)
    String displayName;

    String description;

    @Column(name = "is_active", nullable = false)
    boolean active;

}
