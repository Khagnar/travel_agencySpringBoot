package travelAgency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import travelAgency.entity.Hotel;
import travelAgency.service.HotelServiceImpl;
import java.util.List;

@Controller
@RequestMapping(path = "hotel")
public class HotelController {
    
    private HotelServiceImpl hotelService;

    @Autowired
    public void setHotelService(HotelServiceImpl hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping(path = "get/{id}")
    public @ResponseBody
    String getHotelById(@PathVariable long id) {
        return "Hotel: " + hotelService.getById(id);
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody
    List<Hotel> getAllHotels() {
        return hotelService.getAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addHotel(@RequestParam String name) {
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotelService.add(hotel);
        return "Hotel " + hotel.getName() + " was added" ;
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateHotel(@PathVariable long id, @RequestParam String name) {
        hotelService.update(id, name);
        return "Hotel " + hotelService.getById(id).getName() + " was updated";
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteHotel(@PathVariable long id) {
        hotelService.delete(id);
        return "Hotel with Id = " + id + " was deleted";
    }
}
