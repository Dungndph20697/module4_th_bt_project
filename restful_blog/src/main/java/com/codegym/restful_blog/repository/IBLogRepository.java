package com.codegym.restful_blog.repository;

import com.codegym.restful_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Blob;

@Repository
public interface IBLogRepository extends JpaRepository<Blog, Long> {
}
