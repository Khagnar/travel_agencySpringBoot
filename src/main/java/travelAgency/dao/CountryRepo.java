package travelAgency.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import travelAgency.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Long> {
}
