package com.codegym.demo1.bt.formyte.controller;

import com.codegym.demo1.bt.formyte.model.FormYTe;
import com.codegym.demo1.bt.formyte.model.TrieuChung;
import com.codegym.demo1.bt.formyte.service.IFormYTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/bt/formyte")
public class ControllerFormYTe {

    @Autowired
    private IFormYTeService formYTeService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("listForm", formYTeService.findAll());
        return "/bt/donyte/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("listNamSinh", genNamSinh());
        model.addAttribute("ngay", genNgay());
        model.addAttribute("thang", genThang());
        model.addAttribute("nam", genNam());
        model.addAttribute("formYTe", new FormYTe());
        return "/bt/donyte/create";
    }

    @GetMapping("/update/{id}")
    public String formUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("listNamSinh", genNamSinh());
        model.addAttribute("ngay", genNgay());
        model.addAttribute("thang", genThang());
        model.addAttribute("nam", genNam());
        FormYTe formYTe = (FormYTe) formYTeService.findById(id);
        model.addAttribute("formYTe", formYTe);
        return "/bt/donyte/update";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("formYTe") FormYTe formYTe) {
        formYTe.setId((int) (Math.random() * 10000));
        formYTeService.save(formYTe);
        return "redirect:/bt/formyte";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("formYTe") FormYTe formYTe) {
        formYTeService.update(formYTe.getId(), formYTe);
        return "redirect:/bt/formyte";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") Integer id, Model model) {
        FormYTe formYTe = (FormYTe) formYTeService.findById(id);
        model.addAttribute("formYTe", formYTe);
        return "/bt/donyte/detail";
    }

    private List<Integer> genNamSinh() {
        List<Integer> namSinh = new ArrayList<>();
        for (int i = 1950; i <= 2025; i++) {
            namSinh.add(i);
        }
        return namSinh;
    }

    private List<Integer> genNgay() {
        List<Integer> ngay = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            ngay.add(i);
        }
        return ngay;
    }

    private List<Integer> genThang() {
        List<Integer> thang = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            thang.add(i);
        }
        return thang;
    }

    private List<Integer> genNam() {
        List<Integer> nam = new ArrayList<>();
        for (int i = 2020; i <= 2030; i++) {
            nam.add(i);
        }
        return nam;
    }

}
