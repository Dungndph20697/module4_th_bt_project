package com.codegym.demo1.bt.luutruhomthudientu.service;

import java.util.List;

public interface IHomThuService<H> {
    List<H> getAll();

    H findById(Long id);

    void save(H h);

    void update(Long id, H h);


}
