package com.mitusov.dao;

import com.mitusov.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getAllCustomers();

    void saveCustomer(Customer customer);

    Customer findCustomerById(int id);

    void deleteUser(int id);
}
