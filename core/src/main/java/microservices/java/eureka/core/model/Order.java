package microservices.java.eureka.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ord_order")
@AttributeOverrides({
          @AttributeOverride(name = "dtCriation", column = @Column(name = "ord_dt_criation"))
        , @AttributeOverride(name = "dtModification", column = @Column(name = "ord_dt_modification"))
})
public class Order extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ord_order")
    @Column(name = "ord_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usu_id")
    private ApplicationUser customer;

    @OneToMany
    @JoinColumn(name = "ito_id")
    private Set<ItemOrder> items = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApplicationUser getCustomer() {
        return customer;
    }

    public void setCustomer(ApplicationUser customer) {
        this.customer = customer;
    }

    public Set<ItemOrder> getItems() {
        return items;
    }

    public void setItems(Set<ItemOrder> items) {
        this.items = items;
    }
}

