package microservices.java.eureka.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeliveryDto {

    private Long orderId;
    private String city;
    private String street;
    private String houseNumber;

}
