package sales.controller;

import microservices.java.eureka.core.dto.DeliveryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("deliveries")
@CrossOrigin
public class SalesDeliveryController {

    @PostMapping
    public ResponseEntity delivery(@RequestBody DeliveryDto dto) {

        return ResponseEntity.ok(null);
    }


}
