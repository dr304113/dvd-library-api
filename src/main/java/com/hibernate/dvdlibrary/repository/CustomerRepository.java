package com.hibernate.dvdlibrary.repository;

import com.hibernate.dvdlibrary.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    void createCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerById(int id);

    void updateCustomer(Customer customer);

    void deleteCustomerById(int id);

}
