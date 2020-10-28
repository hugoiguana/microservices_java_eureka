package microservices.java.eureka.sales.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import microservices.java.eureka.core.model.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "usu_user")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "usu_id"))
        , @AttributeOverride(name = "dtCriation", column = @Column(name = "usu_dt_criation"))
        , @AttributeOverride(name = "dtModification", column = @Column(name = "usu_dt_modification"))
})
public class ApplicationUser extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id", nullable = false)
    private Long id;

    @NotNull(message = "The field 'username' is mandatory")
    @Column(name = "usu_name", nullable = false)
    private String userName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "add_id")
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}