package com.kortov.webcustomer.dao;

import com.kortov.webcustomer.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAll();

    void save(Customer customer);

    Customer get(int id);

    void delete(int id);
}
