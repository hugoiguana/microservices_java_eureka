package microservices.java.eureka.sales.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class AbstractEntity implements Serializable {

    @Column(nullable = false)
    private LocalDateTime dtCriation;

    @Column(nullable = false)
    private LocalDateTime dtModification;

    public void prePersist() {
        dtCriation = LocalDateTime.now();
        dtModification = LocalDateTime.now();
    }

}