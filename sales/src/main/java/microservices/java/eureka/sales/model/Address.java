package microservices.java.eureka.sales.model;


import lombok.*;
import microservices.java.eureka.core.model.AbstractEntity;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "add_address")
@AttributeOverrides({
        @AttributeOverride(name = "dtCriation", column = @Column(name = "add_dt_criation"))
        , @AttributeOverride(name = "dtModification", column = @Column(name = "add_dt_modification"))
})
public class Address extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_add_address")
    @Column(name = "add_id")
    private Long id;

    @Column(name = "add_city", nullable = false)
    private String city;

    @Column(name = "add_street", nullable = false)
    private String street;

    @Column(name = "add_house_number", nullable = false)
    private String houseNumber;


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
}