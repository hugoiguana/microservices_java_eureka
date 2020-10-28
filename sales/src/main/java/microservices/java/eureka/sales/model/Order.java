package microservices.java.eureka.sales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import microservices.java.eureka.core.model.AbstractEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
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

    public void addItems(Set<ItemOrder> items) {
        if (this.items == null) {
            this.items = new HashSet<>();
        }
        for (ItemOrder itemOrder : items) {
            itemOrder.setOrder(this);
        }
        this.items = items;
    }
}

