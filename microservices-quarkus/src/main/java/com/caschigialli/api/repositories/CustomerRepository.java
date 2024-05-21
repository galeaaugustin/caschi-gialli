package com.caschigialli.api.repositories;

import com.caschigialli.api.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByUserName(String userName);
}