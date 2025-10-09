package com.codegym.bt_spring_security_phan_quyen.controller;

import com.codegym.bt_spring_security_phan_quyen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @RequestMapping("")
    public String hello() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            System.out.println(((UserDetails) principal).getUsername());
        } else {
            System.out.println(principal.toString());
        }
        return "Hello World";
    }
}
