package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer save(Customer customer);

    Customer update(Customer customer);

    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    void delete(Long id);
}
