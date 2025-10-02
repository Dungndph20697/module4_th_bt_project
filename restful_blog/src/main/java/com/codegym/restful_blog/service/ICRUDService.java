package com.codegym.restful_blog.service;

import java.util.Optional;

public interface ICRUDService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T customer);

    void remove(Long id);
}
