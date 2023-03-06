package com.hibernate.dvdlibrary.repository;

import com.hibernate.dvdlibrary.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public CustomerRepositoryImpl() {

    }

    @Override
    public void createCustomer(Customer customer) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error caused by: " + e.getMessage());
        }
        session.close();

    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            customers = session.createQuery("FROM Customer", Customer.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error caused by: " + e.getMessage());
        }
        session.close();
        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = null;
        Customer customer = new Customer();

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            customer = (Customer) session.createQuery("FROM Customer WHERE id = :id", Customer.class)
                    .setParameter("id", id)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error caused by: " + e.getMessage());
        }
        session.close();
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error caused by: " + e.getMessage());
        }
        session.close();

    }

    @Override
    public void deleteCustomerById(int id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Customer customer = getCustomerById(id);
            session.delete(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error caused by: " + e.getMessage());
        }
        session.close();
    }
}
