package com.codegym.customerprovincemanagement.service.impl;

import com.codegym.customerprovincemanagement.model.Customer;
import com.codegym.customerprovincemanagement.model.Province;
import com.codegym.customerprovincemanagement.repository.ICustomerRepository;
import com.codegym.customerprovincemanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository repository;

    @Override
    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return repository.findAllByProvince(province);
    }
}
