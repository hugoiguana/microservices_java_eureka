package microservices.java.eureka.sales.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
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
    @Column(nullable = false)
    private Long id;

    @NotNull(message = "The field 'username' is mandatory")
    @Column(name = "usu_name", nullable = false)
    private String userName;

    @NotNull(message = "The field 'password' is mandatory")
    @ToString.Exclude
    @Column(name = "usu_password", nullable = false)
    private String password;

    @NotNull(message = "The field 'role' is mandatory")
    @Builder.Default
    @Column(name = "usu_role", nullable = false)
    private String role = "USER";

    public ApplicationUser(@NotNull ApplicationUser applicationUser) {
        this.setId(applicationUser.getId());
        this.userName = applicationUser.getUserName();
        this.password = applicationUser.getPassword();
        this.role = applicationUser.getRole();
    }

}