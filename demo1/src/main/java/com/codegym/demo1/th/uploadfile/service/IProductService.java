package com.codegym.demo1.th.uploadfile.service;

import com.codegym.demo1.th.uploadfile.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
