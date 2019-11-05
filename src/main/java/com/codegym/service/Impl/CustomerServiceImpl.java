package com.codegym.service.Impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;

import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
