package microservices.java.eureka.sales.kafka.producer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding(Source.class)
@Getter
@Setter
@AllArgsConstructor
public class DeliveryProducer {
    private Source mySource;
}
