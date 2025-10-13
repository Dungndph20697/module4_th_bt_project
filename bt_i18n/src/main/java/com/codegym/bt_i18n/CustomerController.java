package com.codegym.bt_i18n;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CustomerController {
    @GetMapping("/")
    public String home(Model model) {
        return "customer";
    }
}
