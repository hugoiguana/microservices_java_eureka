package microservices.java.eureka.core.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ito_item_order")
@AttributeOverrides({
          @AttributeOverride(name = "dtCriation", column = @Column(name = "ito_dt_criation"))
        , @AttributeOverride(name = "dtModification", column = @Column(name = "ito_dt_modification"))
})
public class ItemOrder extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ito_item_order")
    @Column(name = "ito_id")
    private Long id;

    @Column(name = "pro_quantity", nullable = false)
    private Integer quantity;

    @OneToOne
    @JoinColumn(name="prd_id")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}