package com.aurora.redis_example.repository;

import com.aurora.redis_example.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dhanushka Paranavithana
 * @since 27/10/2021  23:35
 **/

@Repository
public class CustomerRepo {


    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate template;

    public static final String HASH_KEY = "Customer";

    public Customer saveCustomer(Customer customer){
        template.opsForHash().put(HASH_KEY ,customer.getCustomerID() , customer);
        return customer;
    }

    public List<Customer> getCustomerList(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Customer getCustomerByID(Integer customerID){
        return (Customer)template.opsForHash().get(HASH_KEY, customerID);

    }

    public String deleteCustomer(Integer customerID){
         template.opsForHash().delete(HASH_KEY, customerID);
         return "Customer is Removed..!";

    }
}
