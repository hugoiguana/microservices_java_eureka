package sales.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import microservices.java.eureka.core.model.AbstractEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "dlv_delivery")
@AttributeOverrides({
        @AttributeOverride(name = "dtCriation", column = @Column(name = "dlv_dt_criation"))
        , @AttributeOverride(name = "dtModification", column = @Column(name = "dlv_dt_modification"))
})
public class Delivery extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dlv_delivery")
    @Column(name = "dlv_id")
    private Long id;

    @Column(name = "dlv_order_id")
    private Long orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}
