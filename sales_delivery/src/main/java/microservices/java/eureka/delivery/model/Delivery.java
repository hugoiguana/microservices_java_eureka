package microservices.java.eureka.delivery.model;

import lombok.*;
import microservices.java.eureka.core.model.AbstractEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @OneToOne(mappedBy = "delivery", cascade = CascadeType.PERSIST)
    private DeliveryAddress address;

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

    public DeliveryAddress getAddress() {
        return address;
    }

    public void setAddress(DeliveryAddress address) {
        this.address = address;
    }
}
