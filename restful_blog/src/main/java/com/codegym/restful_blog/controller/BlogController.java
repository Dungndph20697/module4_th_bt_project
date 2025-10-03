package com.codegym.restful_blog.controller;

import com.codegym.restful_blog.model.Blog;
import com.codegym.restful_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAll(){
        List<Blog> list = (List<Blog>) blogService.findAll();
        if (list.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(blogService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(blogService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Blog> save(@RequestBody Blog blog){
        return ResponseEntity.ok(blogService.save(blog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable("id") Long id, @RequestBody Blog blog){
        blog.setId(id);
        return ResponseEntity.ok(blogService.save(blog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Long id){
        blogService.remove(id);
        return ResponseEntity.ok().build();
    }
}
