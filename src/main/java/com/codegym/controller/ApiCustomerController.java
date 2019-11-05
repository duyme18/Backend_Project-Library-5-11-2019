package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ApiCustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/api/customer")
    public ResponseEntity<List<Customer>> getCustomerList(){
        List<Customer> customers = (List<Customer>) customerService.findAll();

        if(customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/api/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        Customer customer = customerService.findById(id);

        if(customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @PostMapping("/api/customer")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {
        customerService.save(customer);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/customer/{id}")
    public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer, @PathVariable Long id){
        Customer customer1 = customerService.findById(id);
        if(customer1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customer1.setName(customer.getName());
        customerService.save(customer1);

        return new ResponseEntity<>(customer1,HttpStatus.OK);
    }

    @DeleteMapping("/api/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        Customer customer = customerService.findById(id);

        if(customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
