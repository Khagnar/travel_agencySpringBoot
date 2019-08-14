package travelAgency.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import travelAgency.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
