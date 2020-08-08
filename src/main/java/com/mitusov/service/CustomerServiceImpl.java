package com.mitusov.service;

import com.mitusov.dao.CustomerDAO;
import com.mitusov.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer findCustomerById(int id) {
        return customerDAO.findCustomerById(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        customerDAO.deleteUser(id);
    }
}
