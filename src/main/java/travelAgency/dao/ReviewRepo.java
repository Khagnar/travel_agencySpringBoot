package travelAgency.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import travelAgency.entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {
}
