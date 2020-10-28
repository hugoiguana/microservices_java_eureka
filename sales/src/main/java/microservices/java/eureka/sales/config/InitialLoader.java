package microservices.java.eureka.sales.config;

import microservices.java.eureka.sales.model.Address;
import microservices.java.eureka.sales.model.ApplicationUser;
import microservices.java.eureka.sales.model.Product;
import microservices.java.eureka.sales.repository.ApplicationUserRepository;
import microservices.java.eureka.sales.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@Profile("dev")
@Configuration
public class InitialLoader implements CommandLineRunner {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Address address = Address.builder().city("Lisbon").houseNumber("13").street("Street A").build();
        ApplicationUser customer1 = ApplicationUser.builder().userName("Hugo iguana").address(address).build();
        applicationUserRepository.save(customer1);

        Product product1 = Product.builder().name("Product 1").price(BigDecimal.valueOf(150.99)).build();
        Product product2 = Product.builder().name("Product 2").price(BigDecimal.valueOf(1.5)).build();
        Product product3 = Product.builder().name("Product 3").price(BigDecimal.valueOf(5670.00)).build();
        Product product4 = Product.builder().name("Product 4").price(BigDecimal.valueOf(2500)).build();

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);

    }
}
