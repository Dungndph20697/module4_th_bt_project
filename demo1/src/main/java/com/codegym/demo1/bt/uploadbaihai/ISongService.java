package com.codegym.demo1.bt.uploadbaihai;

import java.util.List;

public interface ISongService<S> {
    List<S> findAll();

    void save(S s);
}
