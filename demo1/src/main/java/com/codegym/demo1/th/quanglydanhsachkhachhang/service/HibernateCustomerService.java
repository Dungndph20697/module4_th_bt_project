package com.codegym.demo1.th.quanglydanhsachkhachhang.service;

import com.codegym.demo1.th.quanglydanhsachkhachhang.model.Customer;

import java.util.List;

public interface HibernateCustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void remove(int id);
}
