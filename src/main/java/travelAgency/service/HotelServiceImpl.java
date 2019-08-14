package travelAgency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelAgency.dao.HotelRepo;
import travelAgency.entity.Hotel;
import java.util.List;

@Service
public class HotelServiceImpl implements CommonService<Hotel> {

    private HotelRepo hotelRepo;

    @Autowired
    public void setHotelRepo(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Override
    public Hotel getById(long id) {
        return hotelRepo.getOne(id);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public void add(Hotel hotel) {
        hotelRepo.save(hotel);
    }

    @Override
    public void update(long id, String... args) {
        Hotel hotel = hotelRepo.getOne(id);
        hotel.setName(args[0]);
        hotelRepo.save(hotel);
    }

    @Override
    public void delete(long id) {
        hotelRepo.deleteById(id);
    }
}
