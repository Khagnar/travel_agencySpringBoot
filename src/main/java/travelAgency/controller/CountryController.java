package travelAgency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import travelAgency.entity.Country;
import travelAgency.service.CountryServiceImpl;
import java.util.List;

@Controller
@RequestMapping(path = "country")
public class CountryController {

    private CountryServiceImpl countryService;

    @Autowired
    public void setCountryService(CountryServiceImpl countryService) {
        this.countryService = countryService;
    }

    @GetMapping(path = "get/{id}")
    public @ResponseBody
    String getCountryById(@PathVariable long id) {
        return "Country: " + countryService.getById(id);
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody
    List<Country> getAllCountries() {
        return countryService.getAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addCountry(@RequestParam String name) {
        Country country = new Country();
        country.setName(name);
        countryService.add(country);
        return "Country " + country.getName() + " was added" ;
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateCountry(@PathVariable long id, @RequestParam String name) {
        countryService.update(id, name);
        return "Country " + countryService.getById(id).getName() + " was updated";
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteCountry(@PathVariable long id) {
        countryService.delete(id);
        return "Country with Id = " + id + " was deleted";
    }
}
