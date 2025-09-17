package com.codegym.demo1.bt.formyte.service;

import java.util.List;
import java.util.Map;

public interface IFormYTeService<F> {

    List<F> findAll();

    F findById(Integer id);

    void save(F f);

    void update(Integer id, F f);

}
