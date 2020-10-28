package microservices.java.eureka.sales.repository;

import microservices.java.eureka.sales.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}