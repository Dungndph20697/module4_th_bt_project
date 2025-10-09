package com.codegym.bt_spring_security_phan_quyen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String user() {
        return "/index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }
}
