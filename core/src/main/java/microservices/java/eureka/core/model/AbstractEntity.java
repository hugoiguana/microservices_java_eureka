package microservices.java.eureka.core.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class AbstractEntity implements Serializable {

    @Column(nullable = false)
    private LocalDateTime dtCriation;

    @Column(nullable = false)
    private LocalDateTime dtModification;

    public LocalDateTime getDtCriation() {
        return dtCriation;
    }

    public void setDtCriation(LocalDateTime dtCriation) {
        this.dtCriation = dtCriation;
    }

    public LocalDateTime getDtModification() {
        return dtModification;
    }

    public void setDtModification(LocalDateTime dtModification) {
        this.dtModification = dtModification;
    }

    public void prePersist() {
        dtCriation = LocalDateTime.now();
        dtModification = LocalDateTime.now();
    }

}