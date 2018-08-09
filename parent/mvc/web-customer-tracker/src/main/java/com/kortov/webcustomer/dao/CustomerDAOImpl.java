package com.kortov.webcustomer.dao;

import com.kortov.webcustomer.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
        return session.createQuery("from Customer order by lastName", Customer.class).getResultList();
    }

    @Override
    public void save(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where id =: id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
