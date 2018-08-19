package com.kortov.springdemo.rest;

import com.kortov.springdemo.entity.Customer;
import com.kortov.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = Optional.ofNullable(customerService.getCustomer(customerId))
                .orElseThrow(() -> new CustomerNotFoundException("Customer id not found - " + customerId));
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer udpdateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Optional.ofNullable(customerService.getCustomer(customerId))
                .orElseThrow(() -> new CustomerNotFoundException("Customer id not found - " + customerId));
        customerService.deleteCustomer(customerId);
        return "Deleted customer id  - " + customerId;
    }
}
