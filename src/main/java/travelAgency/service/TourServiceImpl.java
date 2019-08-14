package travelAgency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelAgency.dao.TourRepo;
import travelAgency.entity.Country;
import travelAgency.entity.Hotel;
import travelAgency.entity.Review;
import travelAgency.entity.Tour;
import java.util.List;

@Service
public class TourServiceImpl implements CommonService<Tour> {

    private TourRepo tourRepo;

    @Autowired
    public void setTourRepo(TourRepo tourRepo) {
        this.tourRepo = tourRepo;
    }

    @Override
    public Tour getById(long id) {
        return tourRepo.getOne(id);
    }

    @Override
    public List<Tour> getAll() {
        return tourRepo.findAll();
    }

    @Override
    public void add(Tour tour) {
        tourRepo.save(tour);
    }

    @Override
    public void update(long id, String... args) {
        Tour tour = tourRepo.getOne(id);

        Country country = new Country();
        country.setCountryId(Long.parseLong(args[1]));

        Hotel hotel = new Hotel();
        hotel.setHotelId(Long.parseLong(args[2]));

        Review review = new Review();
        review.setReviewId(Long.parseLong(args[3]));

        tour.setName(args[0]);
        tour.setCountry(country);
        tour.setHotel(hotel);
        tour.setReview(review);
        tourRepo.save(tour);
    }

    @Override
    public void delete(long id) {
        tourRepo.deleteById(id);
    }
}
