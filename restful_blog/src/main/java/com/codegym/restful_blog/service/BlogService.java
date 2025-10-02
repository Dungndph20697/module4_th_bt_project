package com.codegym.restful_blog.service;

import com.codegym.restful_blog.model.Blog;
import com.codegym.restful_blog.repository.IBLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBLogRepository bLogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return bLogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return bLogRepository.findById(id);
    }

    @Override
    public Blog save(Blog customer) {
        return bLogRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        bLogRepository.deleteById(id);
    }
}
