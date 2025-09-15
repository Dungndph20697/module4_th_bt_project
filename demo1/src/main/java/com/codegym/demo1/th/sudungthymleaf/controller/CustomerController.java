package com.codegym.demo1.th.sudungthymleaf.controller;

import com.codegym.demo1.th.sudungthymleaf.model.Customer;
import com.codegym.demo1.th.sudungthymleaf.service.CustomerServiceImpl;
import com.codegym.demo1.th.sudungthymleaf.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final ICustomerService customerService = new CustomerServiceImpl();

    @GetMapping
    public String index(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        model.addAttribute("success", "");
        return "/th/sudungthymleaf/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "/th/sudungthymleaf/create";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirect) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Added customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/th/sudungthymleaf/update";

    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirect) {
        customerService.update(customer.getId(), customer);
        redirect.addFlashAttribute("success", "Updated customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/th/sudungthymleaf/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/th/sudungthymleaf/view";
    }
}
