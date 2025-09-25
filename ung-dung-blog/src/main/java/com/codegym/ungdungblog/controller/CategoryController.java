package com.codegym.ungdungblog.controller;

import com.codegym.ungdungblog.model.Category;
import com.codegym.ungdungblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public String showCategory(@RequestParam("page") Optional<Integer> page, Model model) {
        int currentPage = page.orElse(0);
        Pageable pageable = PageRequest.of(currentPage, 5);
        Page<Category> categories = categoryService.findAll(pageable);
        model.addAttribute("categories", categories);
        return "/category/list";
    }

    @GetMapping("/create")
    public String showCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/update/{id}")
    public String showUpdateCategory(@PathVariable("id") Long id, Model model) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "/category/update";
        } else {
            return "redirect:/category";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        categoryService.remove(id);
        return "redirect:/category";
    }

    @PostMapping("/update/{id}")
    public String saveCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

}
