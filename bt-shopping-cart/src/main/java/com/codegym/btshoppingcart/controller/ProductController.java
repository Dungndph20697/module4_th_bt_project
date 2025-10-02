package com.codegym.btshoppingcart.controller;

import com.codegym.btshoppingcart.model.Cart;
import com.codegym.btshoppingcart.model.Product;
import com.codegym.btshoppingcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/products")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "trangchu";
    }

    @GetMapping("/add/{id}")
    public String addProductToCart(@ModelAttribute("cart") Cart cart, @PathVariable("id") Long id,@RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            product.get().setQuantity(1);
            cart.addProduct(product.get());
        }
        return "redirect:/products";
    }

    @GetMapping("/detail/{id}")
    public String showProductDetail(@PathVariable("id") Long id, Model model, @RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "chi-tiet";
        } else {
            return "redirect:/products";
        }
    }
}
