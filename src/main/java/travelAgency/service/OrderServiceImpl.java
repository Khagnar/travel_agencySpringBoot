package travelAgency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelAgency.dao.OrderRepo;
import travelAgency.entity.Customer;
import travelAgency.entity.Order;
import travelAgency.entity.Tour;

import java.util.List;

@Service
public class OrderServiceImpl implements CommonService<Order> {

    private OrderRepo orderRepo;

    @Autowired
    public void setOrderRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order getById(long id) {
        return orderRepo.getOne(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    @Override
    public void add(Order order) {
        orderRepo.save(order);
    }

    @Override
    public void update(long id, String... args) {
        Order order = orderRepo.getOne(id);

        Customer customer = new Customer();
        customer.setCustomerId(Long.parseLong(args[0]));

        Tour tour = new Tour();
        tour.setTourId(Long.parseLong(args[1]));

        order.setCustomer(customer);
        order.setTour(tour);
        orderRepo.save(order);
    }

    @Override
    public void delete(long id) {
        orderRepo.deleteById(id);
    }
}
