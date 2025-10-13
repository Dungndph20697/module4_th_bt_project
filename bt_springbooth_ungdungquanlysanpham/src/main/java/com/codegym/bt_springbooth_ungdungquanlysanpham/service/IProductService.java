package com.codegym.bt_springbooth_ungdungquanlysanpham.service;

import java.util.List;

public interface IProductService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);

}
