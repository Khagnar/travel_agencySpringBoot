package travelAgency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelAgency.dao.CountryRepo;
import travelAgency.entity.Country;
import java.util.List;

@Service
public class CountryServiceImpl implements CommonService<Country> {

    private CountryRepo countryRepo;

    @Autowired
    public void setCountryRepo(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public Country getById(long id) {
        return countryRepo.getOne(id);
    }

    @Override
    public List<Country> getAll() {
        return countryRepo.findAll();
    }

    @Override
    public void add(Country country) {
        countryRepo.save(country);
    }

    @Override
    public void update(long id, String... args) {
        Country country = countryRepo.getOne(id);
        country.setName(args[0]);
        countryRepo.save(country);
    }

    @Override
    public void delete(long id) {
        countryRepo.deleteById(id);
    }
}
