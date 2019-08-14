package travelAgency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import travelAgency.entity.Customer;
import travelAgency.entity.Order;
import travelAgency.entity.Tour;
import travelAgency.service.OrderServiceImpl;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping(path = "order")
public class OrderController {
    
    private OrderServiceImpl orderService;

    @Autowired
    public void setOrderService(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "get/{id}")
    public @ResponseBody
    String getOrderById(@PathVariable long id) {
        return "Order: " + orderService.getById(id);
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody
    List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addOrder(@RequestParam long customerId,
                                         @RequestParam long tourId,
                                         @RequestParam Timestamp date) {

        Customer customer = new Customer();
        customer.setCustomerId(customerId);

        Tour tour = new Tour();
        tour.setTourId(tourId);

        Order order = new Order();
        order.setCustomer(customer);
        order.setTour(tour);
        order.setDate(date);
        orderService.add(order);
        return "Order was added" ;
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateOrder(@PathVariable long id,
                                            @RequestParam String customerId,
                                            @RequestParam String tourId) {

        orderService.update(id, customerId, tourId);
        return "Order " + orderService.getById(id) + " was updated";
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteOrder(@PathVariable long id) {
        orderService.delete(id);
        return "Order with Id = " + id + " was deleted";
    }
}
