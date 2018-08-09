package com.kortov.webcustomer.dao;

import com.kortov.webcustomer.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Customer> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Customer", Customer.class).getResultList();
    }
}
