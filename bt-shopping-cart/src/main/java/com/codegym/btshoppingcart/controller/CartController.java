package com.codegym.btshoppingcart.controller;


import com.codegym.btshoppingcart.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping()
    public String showCart(@SessionAttribute("cart") Cart cart, Model model){
        model.addAttribute("cart", cart);
        return "giohang";
    }

}
