package com.codegym.btshoppingcart.service;

import com.codegym.btshoppingcart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

}
