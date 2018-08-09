package com.kortov.webcustomer.service;

import com.kortov.webcustomer.dao.CustomerDAO;
import com.kortov.webcustomer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        customerDAO.save(customer);
    }
}
