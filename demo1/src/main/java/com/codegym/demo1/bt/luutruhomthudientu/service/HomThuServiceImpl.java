package com.codegym.demo1.bt.luutruhomthudientu.service;

import com.codegym.demo1.bt.luutruhomthudientu.model.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomThuServiceImpl implements IHomThuService<Email> {

    private static final Map<Long, Email> emails;

    static {
        emails = new HashMap<>();
        emails.put(1l, new Email(1l, "English", 10, true, "Công ty A"));
        emails.put(2l, new Email(2l, "English", 10, true, "Công ty B"));
        emails.put(3l, new Email(3l, "English", 10, true, "Công ty C"));
        emails.put(4l, new Email(4l, "English", 10, false, "Công ty A"));
        emails.put(5l, new Email(5l, "English", 10, false, "Công ty B"));
    }

    @Override
    public List<Email> getAll() {
        return new ArrayList<>(emails.values());
    }

    @Override
    public Email findById(Long id) {
        return emails.get(id);
    }

    @Override
    public void save(Email email) {
        emails.put(email.getId(), email);
    }

    @Override
    public void update(Long id, Email email) {
        emails.put(id, email);
    }
}
