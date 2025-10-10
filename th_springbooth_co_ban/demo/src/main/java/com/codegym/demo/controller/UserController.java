package com.codegym.demo.controller;

import com.codegym.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private IUserRepository userRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

}
