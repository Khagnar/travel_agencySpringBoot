package travelAgency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import travelAgency.entity.Country;
import travelAgency.entity.Hotel;
import travelAgency.entity.Review;
import travelAgency.entity.Tour;
import travelAgency.service.TourServiceImpl;
import java.util.List;

@Controller
@RequestMapping(path = "tour")
public class TourController {

    private TourServiceImpl tourService;

    @Autowired
    public void setTourService(TourServiceImpl tourService) {
        this.tourService = tourService;
    }

    @GetMapping(path = "get/{id}")
    public @ResponseBody
    String getTourById(@PathVariable long id) {
        return "Tour: " + tourService.getById(id);
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody
    List<Tour> getAllTours() {
        return tourService.getAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addTour(@RequestParam String name,
                                        @RequestParam long countryId,
                                        @RequestParam long hotelId,
                                        @RequestParam long reviewId) {
        Tour tour = new Tour();

        Country country = new Country();
        country.setCountryId(countryId);

        Hotel hotel = new Hotel();
        hotel.setHotelId(hotelId);

        Review review = new Review();
        review.setReviewId(reviewId);

        tour.setName(name);
        tour.setCountry(country);
        tour.setHotel(hotel);
        tour.setReview(review);
        tourService.add(tour);

        return "Tour " + tour.getName() + " was added" ;
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateTour(@PathVariable long id,
                                           @RequestParam String name,
                                           @RequestParam String countryId,
                                           @RequestParam String hotelId,
                                           @RequestParam String reviewId) {

        tourService.update(id, name, countryId, hotelId, reviewId);
        return "Tour " + tourService.getById(id).getName() + " was updated";
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteTour(@PathVariable long id) {
        tourService.delete(id);
        return "Tour with Id = " + id + " was deleted";
    }
}
