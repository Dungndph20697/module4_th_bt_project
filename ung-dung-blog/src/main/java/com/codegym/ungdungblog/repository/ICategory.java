package com.codegym.ungdungblog.repository;

import com.codegym.ungdungblog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategory extends JpaRepository<Category, Long> {
}
