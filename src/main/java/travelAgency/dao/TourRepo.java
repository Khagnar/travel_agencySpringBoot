package travelAgency.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import travelAgency.entity.Tour;

public interface TourRepo extends JpaRepository<Tour, Long> {
}
