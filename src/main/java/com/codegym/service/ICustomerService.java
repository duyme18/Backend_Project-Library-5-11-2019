package com.codegym.service;

import com.codegym.model.Customer;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void remove(Long id);

    void save(Customer customer);
}
