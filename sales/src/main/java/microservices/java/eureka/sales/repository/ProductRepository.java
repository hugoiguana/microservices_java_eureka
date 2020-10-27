package microservices.java.eureka.sales.repository;

import microservices.java.eureka.sales.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}