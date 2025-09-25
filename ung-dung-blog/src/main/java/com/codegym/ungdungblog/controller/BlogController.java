package com.codegym.ungdungblog.controller;

import com.codegym.ungdungblog.model.Blog;
import com.codegym.ungdungblog.model.Category;
import com.codegym.ungdungblog.service.IBlogService;
import com.codegym.ungdungblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public String showBlog(@RequestParam("page") Optional<Integer> page, Model model) {
        int currentPage = page.orElse(0);
        Pageable pageable = PageRequest.of(currentPage, 5, Sort.by(Sort.Direction.DESC,"createdDate"));
        Page<Blog> blogs = blogService.findAll(pageable);
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }

    @GetMapping("/create")
    public String showCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/update/{id}")
    public String showUpdateBlog(@PathVariable("id") Long id, Model model) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("blog", blog.get());
            return "/blog/update";
        } else {
            return "redirect:/blog";
        }
    }

    @PostMapping("/update/{id}")
    public String saveBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id).get());
        return "/blog/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        blogService.remove(id);
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String search(@RequestParam("page") Optional<Integer> page, @RequestParam("search") String search, Model model) {
        int currentPage = page.orElse(0);
        Pageable pageable = PageRequest.of(currentPage, 5, Sort.by(Sort.Direction.DESC,"createdDate"));
        Page<Blog> blogs = blogService.findByTitle(pageable,search);
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }
}
