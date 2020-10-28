package microservices.java.eureka.sales.controller;

import ma.glasnost.orika.MapperFacade;
import microservices.java.eureka.sales.dto.SalesDto;
import microservices.java.eureka.sales.model.Order;
import microservices.java.eureka.sales.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sales")
@CrossOrigin
public class SalesController {

    @Autowired
    private SalesService service;

    @Autowired
    private MapperFacade mapper;

    @PostMapping
    public ResponseEntity<Void> buy(@RequestBody SalesDto dto) {
        Order order = mapper.map(dto, Order.class);
        service.buy(order);
        return ResponseEntity.ok().build();
    }
}
