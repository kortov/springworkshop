package com.kortov.webcustomer.service;

import com.kortov.webcustomer.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAll();

    void save(Customer customer);
}
