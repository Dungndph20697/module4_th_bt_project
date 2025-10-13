package com.codegym.bt_springbooth_ungdungquanlysanpham.controller;

import com.codegym.bt_springbooth_ungdungquanlysanpham.model.Product;
import com.codegym.bt_springbooth_ungdungquanlysanpham.service.ProductService;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // Hiển thị danh sách
    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", service.findAll());
        return "product-list";
    }

    // Hiển thị form thêm mới
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    // Lưu sản phẩm (thêm hoặc sửa)
    @PostMapping
    public String save(@ModelAttribute Product product) {
        service.save(product);
        return "redirect:/products";
    }

    // Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "product-form";
    }

    // Xóa sản phẩm
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.remove(id);
        return "redirect:/products";
    }
}
