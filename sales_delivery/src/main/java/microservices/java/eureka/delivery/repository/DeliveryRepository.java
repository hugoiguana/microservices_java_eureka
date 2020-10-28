package microservices.java.eureka.delivery.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import microservices.java.eureka.delivery.model.Delivery;

public interface DeliveryRepository extends PagingAndSortingRepository<Delivery, Long> {

}