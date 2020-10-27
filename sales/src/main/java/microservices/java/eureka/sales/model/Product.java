package microservices.java.eureka.sales.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "prd_product")
@AttributeOverrides({
          @AttributeOverride(name = "dtCriation", column = @Column(name = "prd_dt_criation"))
        , @AttributeOverride(name = "dtModification", column = @Column(name = "prd_dt_modification"))
})
public class Product extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_prd_product")
    @Column(name = "prd_id")
    private Long id;

    @Column(name = "pro_name", nullable = false)
    private String name;

    @Column(name = "pro_price", nullable = false)
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}