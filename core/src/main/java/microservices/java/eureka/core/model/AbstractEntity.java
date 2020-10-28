package microservices.java.eureka.core.model;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.LocalDateTime;

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

    @PrePersist
    public void prePersist() {
        dtCriation = LocalDateTime.now();
        dtModification = LocalDateTime.now();
    }

}