package com.codegym.customerprovincemanagement.service;

import com.codegym.customerprovincemanagement.model.Customer;
import com.codegym.customerprovincemanagement.model.Province;

public interface ICustomerService extends IGenerateService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
