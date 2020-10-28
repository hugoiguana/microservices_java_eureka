package microservices.java.eureka.delivery.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import microservices.java.eureka.delivery.model.DeliveryAddress;

public interface DeliveryAddressRepository extends PagingAndSortingRepository<DeliveryAddress, Long> {

}