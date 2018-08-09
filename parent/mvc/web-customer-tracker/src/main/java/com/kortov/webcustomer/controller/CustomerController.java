package com.kortov.webcustomer.controller;

import com.kortov.webcustomer.dao.CustomerDAO;
import com.kortov.webcustomer.entity.Customer;
import com.kortov.webcustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List<Customer> customers = customerService.getAll();
        theModel.addAttribute("customers", customers);
        return "list-customers";
    }
}
