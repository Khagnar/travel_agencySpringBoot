package travelAgency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import travelAgency.entity.Customer;
import travelAgency.service.CustomerServiceImpl;
import java.util.List;

@Controller
@RequestMapping(path = "customer")
public class CustomerController {

    private CustomerServiceImpl customerService;

    @Autowired
    public void setCustomerService(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "get/{id}")
    public @ResponseBody
    String getCustomerById(@PathVariable long id) {
        return "Customer: " + customerService.getById(id);
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody
    List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addCustomer(@RequestParam String name) {
        Customer customer = new Customer();
        customer.setName(name);
        customerService.add(customer);
        return "Customer " + customer.getName() + " was added" ;
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateCustomer(@PathVariable long id, @RequestParam String name) {
        customerService.update(id, name);
        return "Customer " + customerService.getById(id).getName() + " was updated";
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteCustomer(@PathVariable long id) {
        customerService.delete(id);
        return "Customer with Id = " + id + " was deleted";
    }
}
