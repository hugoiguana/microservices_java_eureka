package microservices.java.eureka.core.repository;

import microservices.java.eureka.core.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}