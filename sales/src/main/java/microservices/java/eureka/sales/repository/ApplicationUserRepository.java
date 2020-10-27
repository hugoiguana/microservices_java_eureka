package microservices.java.eureka.sales.repository;

import microservices.java.eureka.sales.model.ApplicationUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {
}