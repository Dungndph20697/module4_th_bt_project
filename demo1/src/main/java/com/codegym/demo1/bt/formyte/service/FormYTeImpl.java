package com.codegym.demo1.bt.formyte.service;


import com.codegym.demo1.bt.formyte.model.FormYTe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FormYTeImpl implements IFormYTeService<FormYTe> {

    private static final Map<Integer, FormYTe> formYTes;

    static {
        formYTes = new HashMap<>();

    }

    @Override
    public List<FormYTe> findAll() {
        return new ArrayList<>(formYTes.values());
    }

    @Override
    public FormYTe findById(Integer id) {
        return formYTes.get(id);
    }

    @Override
    public void save(FormYTe formYTe) {
        formYTes.put(formYTe.getId(), formYTe);
    }

    @Override
    public void update(Integer id, FormYTe formYTe) {
        formYTes.put(id, formYTe);
    }

}
