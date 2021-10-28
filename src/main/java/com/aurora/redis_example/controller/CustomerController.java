package com.aurora.redis_example.controller;

import com.aurora.redis_example.entity.Customer;
import com.aurora.redis_example.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dhanushka Paranavithana
 * @since 27/10/2021  23:45
 **/

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer){
        System.out.println("customer = " + customer);
        return customerRepo.saveCustomer(customer);
    }

    @GetMapping("/customer")
    public List<Customer> getCustomers(){
        return customerRepo.getCustomerList();
    }

    @DeleteMapping("/customer/{customerID}")
    public String removeCustomer(@PathVariable Integer customerID){
        return customerRepo.deleteCustomer(customerID);
    }

    @GetMapping("/customer/{customerID}")
    public Customer searchCustomer(@PathVariable Integer customerID){
        Customer customer = customerRepo.getCustomerByID(customerID);
        return customer;
    }


}
