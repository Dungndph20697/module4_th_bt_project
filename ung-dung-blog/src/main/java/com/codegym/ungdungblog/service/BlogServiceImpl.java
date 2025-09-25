package com.codegym.ungdungblog.service;

import com.codegym.ungdungblog.model.Blog;
import com.codegym.ungdungblog.repository.IBlogRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository repo;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        LocalDateTime time = LocalDateTime.now();

        if (blog.getId() == null) {

            blog.setCreatedDate(time);
        } else {
            Optional<Blog> blog1 = findById(blog.getId());
            blog.setUpdatedDate(time);
            blog.setCreatedDate(blog1.get().getCreatedDate());
        }
        repo.save(blog);
    }

    @Override
    public void remove(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Page<Blog> findByTitle(Pageable pageable, String search) {
        if (search == null || search.isEmpty()){
            return repo.findAll(pageable);
        }
        return repo.findByTitle(search,pageable);
    }
}
