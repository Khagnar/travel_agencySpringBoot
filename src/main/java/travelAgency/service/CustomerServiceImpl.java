package travelAgency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelAgency.dao.CustomerRepo;
import travelAgency.entity.Customer;
import java.util.List;

@Service
public class CustomerServiceImpl implements CommonService<Customer> {

    private CustomerRepo customerRepo;

    @Autowired
    public void setCustomerRepo(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer getById(long id) {
        return customerRepo.getOne(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

    @Override
    public void add(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void update(long id, String... args) {
        Customer customer = customerRepo.getOne(id);
        customer.setName(args[0]);
        customerRepo.save(customer);
    }

    @Override
    public void delete(long id) {
        customerRepo.deleteById(id);
    }
}
