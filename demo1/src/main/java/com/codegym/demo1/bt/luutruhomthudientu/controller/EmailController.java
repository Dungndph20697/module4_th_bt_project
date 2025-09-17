package com.codegym.demo1.bt.luutruhomthudientu.controller;

import com.codegym.demo1.bt.luutruhomthudientu.model.Email;
import com.codegym.demo1.bt.luutruhomthudientu.service.IHomThuService;
import com.codegym.demo1.bt.sudungthymleaf.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bt/save-email")
public class EmailController {
    @Autowired
    private IHomThuService homThuService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("emailList", homThuService.getAll());
        return "/bt/luutruhomthudientu/list";
    }

    @GetMapping("/create")
    public String showFormCreate( Model model){
        model.addAttribute("email", new Email());
        return "/bt/luutruhomthudientu/save";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("email", homThuService.findById(id));
        return "/bt/luutruhomthudientu/update";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("email") Email email){
        email.setId((long) (Math.random() * 10000));
        homThuService.save(email);
        return "redirect:/bt/save-email";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("email") Email email){
        homThuService.update(email.getId(), email);
        return "redirect:/bt/save-email";
    }
}
