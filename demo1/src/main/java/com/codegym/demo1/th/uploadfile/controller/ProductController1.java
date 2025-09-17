package com.codegym.demo1.th.uploadfile.controller;

import com.codegym.demo1.th.uploadfile.model.Product;
import com.codegym.demo1.th.uploadfile.model.ProductFrom;
import com.codegym.demo1.th.uploadfile.service.IProductService;
import com.codegym.demo1.th.uploadfile.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/th/updloadfile/product")
public class ProductController1 {
    @Value("${file-upload}")
    private String fileUpload;

    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/th/updloadfile/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/th/updloadfile/create");
        modelAndView.addObject("productForm", new ProductFrom());
        return modelAndView;

    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute("productForm") ProductFrom productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(),
                productForm.getDescription(), fileName);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/th/updloadfile/create");
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
}
