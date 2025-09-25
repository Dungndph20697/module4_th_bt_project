package com.codegym.ungdungblog.repository;

import com.codegym.ungdungblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findByTitle(String title, Pageable pageable);
}
