package microservices.java.eureka.sales.controller;

import microservices.java.eureka.core.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/products")
@CrossOrigin
public class ProductController {

    @GetMapping(value = "")
    public ResponseEntity<List<Product>> products() {

        Product product1 = Product.builder().name("product A").build();
        product1.setId(1l);

        Product product2 = Product.builder().name("product B").build();
        product2.setId(2l);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        return ResponseEntity.ok(products);
    }


}
