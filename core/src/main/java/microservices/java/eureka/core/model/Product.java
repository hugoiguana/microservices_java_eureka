package microservices.java.eureka.core.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "prd_product")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "prd_id"))
        , @AttributeOverride(name = "dtCriation", column = @Column(name = "prd_dt_criation"))
        , @AttributeOverride(name = "dtModification", column = @Column(name = "prd_dt_modification"))
})
public class Product extends AbstractEntity {

    @Column(name = "pro_name", nullable = false)
    private String name;

    @Column(name = "pro_price", nullable = false)
    private BigDecimal price;

}