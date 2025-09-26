package com.codegym.validatesong.controller;

import com.codegym.validatesong.model.Song;
import com.codegym.validatesong.service.SongService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/song")
public class SongController {

    private SongService songService;

    public SongController() {
        songService = new SongService();
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("songs", songService.getSongs());
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("song", songService.getSong(id));
        return "update";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Song song, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            songService.addSong(song);
            return "redirect:/song";
        }
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute Song song, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "update";
        } else {
            songService.update(id, song);
            return "redirect:/song";
        }
    }
}
