package microservices.java.eureka.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesDto {

    private Long customerId;
    private Set<ItemOrderDto> items = new HashSet<>();
}
