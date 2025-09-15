package com.codegym.demo1.bt.sudungthymleaf.service;

import com.codegym.demo1.bt.sudungthymleaf.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService<Product> {

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "SP1", 30000d, "Mô tả sản phẩm 1", "Công ty A"));
        products.put(2, new Product(2, "SP2", 30000d, "Mô tả sản phẩm 2", "Công ty B"));
        products.put(3, new Product(3, "SP3", 30000d, "Mô tả sản phẩm 3", "Công ty C"));
        products.put(4, new Product(4, "SP4", 30000d, "Mô tả sản phẩm 4", "Công ty A"));
        products.put(5, new Product(5, "SP5", 30000d, "Mô tả sản phẩm 5", "Công ty B"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
