package com.codegym.ungdungblog.service;

import com.codegym.ungdungblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGenerateService<T> {
    Page<T> findAll(Pageable pageable);

    void save(T t);

    void remove(Long id);

    Optional<T> findById(Long id);
}
