package com.mitusov.service;


import com.mitusov.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    void saveCustomer(Customer customer);

    Customer findCustomerById(int id);

    void deleteUser(int id);
}
