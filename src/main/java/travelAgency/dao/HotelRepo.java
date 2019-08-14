package travelAgency.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import travelAgency.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Long> {
}
