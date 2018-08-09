package com.kortov.webcustomer.controller;

import com.kortov.webcustomer.dao.CustomerDAO;
import com.kortov.webcustomer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {
        List<Customer> customers = customerDAO.getAll();
        theModel.addAttribute("customers", customers);
        return "list-customers";
    }
}
