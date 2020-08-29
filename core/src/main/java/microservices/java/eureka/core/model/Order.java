package microservices.java.eureka.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ord_order")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ord_id"))
        , @AttributeOverride(name = "dtCriation", column = @Column(name = "ord_dt_criation"))
        , @AttributeOverride(name = "dtModification", column = @Column(name = "ord_dt_modification"))
})
public class Order extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "usu_id")
    private ApplicationUser customer;

    @OneToMany
    @JoinColumn(name = "ito_id")
    private Set<ItemOrder> items = new HashSet<>();

}