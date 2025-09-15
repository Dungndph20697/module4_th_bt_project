package com.codegym.demo1.bt.sudungthymleaf.service;

import java.util.List;

public interface IProductService<P> {
    List<P> findAll();

    void save(P p);

    P findById(int id);

    void update(int id, P p);

    void remove(int id);
}
