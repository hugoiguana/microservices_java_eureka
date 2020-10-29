package microservices.java.eureka.delivery.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import microservices.java.eureka.core.dto.DeliveryDto;
import microservices.java.eureka.delivery.model.Delivery;
import microservices.java.eureka.delivery.model.DeliveryAddress;
import microservices.java.eureka.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@EnableBinding(Sink.class)
@Transactional
public class DeliveryConsumer {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @StreamListener(target = Sink.INPUT)
    public void consume(DeliveryDto deliveryDto) {

        DeliveryAddress address = DeliveryAddress.builder()
                .city(deliveryDto.getAddress().getCity())
                .houseNumber(deliveryDto.getAddress().getHouseNumber())
                .street(deliveryDto.getAddress().getStreet())
                .build();

        Delivery delivery = Delivery.builder().orderId(deliveryDto.getOrderId()).address(address).build();
        deliveryRepository.save(delivery);

        log.info("Recieved message deliveryDto : {}", deliveryDto.toString());
    }

}
