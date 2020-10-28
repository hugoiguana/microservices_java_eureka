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
@Table(name = "dla_delivery_address")
@AttributeOverrides({
        @AttributeOverride(name = "dtCriation", column = @Column(name = "dla_dt_criation"))
        , @AttributeOverride(name = "dtModification", column = @Column(name = "dla_dt_modification"))
})
public class DeliveryAddress extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dla_delivery_address")
    @Column(name = "dla_id")
    private Long id;

    @Column(name = "dla_city")
    private String city;

    @Column(name = "dla_street")
    private String street;

    @Column(name = "dla_house_number")
    private String houseNumber;

    @OneToOne
    @JoinColumn(name = "dlv_id")
    private Delivery delivery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
