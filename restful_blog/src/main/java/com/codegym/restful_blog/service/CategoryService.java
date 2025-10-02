package com.codegym.restful_blog.service;

import com.codegym.restful_blog.model.Category;
import com.codegym.restful_blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category customer) {
        return categoryRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
