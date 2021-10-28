package com.aurora.redis_example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * @author Dhanushka Paranavithana
 * @since 27/10/2021  23:15
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Customer")
public class Customer implements Serializable {

    @Id
    private Integer customerID;

    private String customerName;

    private String address;

    private Double salary;

}
