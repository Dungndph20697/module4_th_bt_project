package com.codegym.bt_springbooth_ungdungquanlysanpham.service;

import com.codegym.bt_springbooth_ungdungquanlysanpham.model.Product;
import com.codegym.bt_springbooth_ungdungquanlysanpham.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService<Product> {
    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public void remove(Long id) {
        repo.deleteById(id);
    }
}
