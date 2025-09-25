package com.codegym.ungdungblog.service;

import com.codegym.ungdungblog.model.Category;

import java.util.List;

public interface ICategoryService extends IGenerateService<Category>{
    List<Category> findAll();
}
