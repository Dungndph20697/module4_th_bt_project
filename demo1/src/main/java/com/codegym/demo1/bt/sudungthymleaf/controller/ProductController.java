package com.codegym.demo1.bt.sudungthymleaf.controller;

import com.codegym.demo1.bt.sudungthymleaf.model.Product;
import com.codegym.demo1.bt.sudungthymleaf.service.IProductService;
import com.codegym.demo1.bt.sudungthymleaf.service.ProductServiceImpl;
import com.codegym.demo1.th.sudungthymleaf.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showView(Model model){
        List<Product> list = productService.findAll();
        model.addAttribute("products", list);
        return "/bt/sudungthymleaf/index";
    }

    @GetMapping("/create")
    public String showViewCreate(Model model){
        model.addAttribute("product", new Product());
        return "/bt/sudungthymleaf/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirect) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Added customer successfully!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/bt/sudungthymleaf/update";

    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Updated customer successfully!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/bt/sudungthymleaf/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/bt/sudungthymleaf/view";
    }
}
