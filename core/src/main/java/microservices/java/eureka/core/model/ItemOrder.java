package microservices.java.eureka.core.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ito_item_order")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ito_id"))
        , @AttributeOverride(name = "dtCriation", column = @Column(name = "ito_dt_criation"))
        , @AttributeOverride(name = "dtModification", column = @Column(name = "ito_dt_modification"))
})
public class ItemOrder extends AbstractEntity {

    @Column(name = "pro_quantity", nullable = false)
    private Integer quantity;

    @OneToOne
    @JoinColumn(name="prd_id")
    private Product product;

}