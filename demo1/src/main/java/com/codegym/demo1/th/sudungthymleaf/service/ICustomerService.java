package com.codegym.demo1.th.sudungthymleaf.service;

import com.codegym.demo1.th.sudungthymleaf.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
