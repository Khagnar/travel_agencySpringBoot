package travelAgency.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import travelAgency.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
