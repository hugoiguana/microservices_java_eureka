package microservices.java.eureka.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan({"microservices.java.eureka.delivery.model"})
@EnableJpaRepositories({"microservices.java.eureka.delivery.repository"})
@ComponentScan("microservices.java.eureka")
@SpringBootApplication
public class SalesDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesDeliveryApplication.class, args);
    }

}
