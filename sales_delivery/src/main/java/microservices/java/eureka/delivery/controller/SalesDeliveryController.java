package microservices.java.eureka.delivery.controller;

import microservices.java.eureka.core.dto.DeliveryDto;
import microservices.java.eureka.delivery.model.Delivery;
import microservices.java.eureka.delivery.model.DeliveryAddress;
import microservices.java.eureka.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("deliveries")
@CrossOrigin
public class SalesDeliveryController {

    @Autowired
    private DeliveryRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Delivery>> deliveries() {
        Iterable<Delivery> deliveries = repository.findAll();
        return ResponseEntity.ok(deliveries);
    }

    @PostMapping
    public ResponseEntity<Void> delivery(@RequestBody DeliveryDto dto) {
        DeliveryAddress address = DeliveryAddress.builder()
                .city(dto.getAddress().getCity())
                .houseNumber(dto.getAddress().getHouseNumber())
                .street(dto.getAddress().getStreet())
                .build();

        Delivery delivery = Delivery.builder().orderId(dto.getOrderId()).address(address).build();
        repository.save(delivery);

        return ResponseEntity.ok().build();
    }


}
