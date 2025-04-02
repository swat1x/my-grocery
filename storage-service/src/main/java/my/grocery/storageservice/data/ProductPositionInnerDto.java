package my.grocery.storageservice.data;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter

@FieldDefaults(level = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductPositionInnerDto {

    UUID id;

    String displayName;

    String description;

    boolean active;

}
