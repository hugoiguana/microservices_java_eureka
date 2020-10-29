package microservices.java.eureka.sales.service;

import lombok.extern.slf4j.Slf4j;
import microservices.java.eureka.core.dto.AddressDto;
import microservices.java.eureka.core.dto.DeliveryDto;
import microservices.java.eureka.sales.kafka.producer.DeliveryProducer;
import microservices.java.eureka.sales.model.Address;
import microservices.java.eureka.sales.model.ApplicationUser;
import microservices.java.eureka.sales.model.Order;
import microservices.java.eureka.sales.repository.ApplicationUserRepository;
import microservices.java.eureka.sales.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Slf4j
@Service
@Transactional
public class SalesService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DeliveryProducer deliveryProducer;

    @Value("${endpoint.gateway.sales_delivery}")
    private String urlEndpointDelivery;

    public void buy(Order order) {
        repository.save(order);
        sendOrderToDelivery(order);
    }

    private void sendOrderToDelivery(Order order) {

        ApplicationUser applicationUser = applicationUserRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Address address = applicationUser.getAddress();

        AddressDto addressDto = AddressDto.builder()
                .city(address.getCity())
                .houseNumber(address.getHouseNumber())
                .street(address.getStreet())
                .build();

        DeliveryDto deliveryDto = DeliveryDto.builder().orderId(order.getId()).address(addressDto).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<DeliveryDto> httpEntity = new HttpEntity<DeliveryDto>(deliveryDto, headers);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(urlEndpointDelivery, HttpMethod.POST, httpEntity, Void.class);
        log.info("Delivery DTO sended to sales_delivery application with return status = {}.", responseEntity.getStatusCode());

        deliveryProducer.getMySource().output().send(MessageBuilder.withPayload(deliveryDto).build());
    }
}
