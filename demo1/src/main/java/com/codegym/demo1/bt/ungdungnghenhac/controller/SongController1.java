package com.codegym.demo1.bt.ungdungnghenhac.controller;

import com.codegym.demo1.bt.ungdungnghenhac.model.Song;
import com.codegym.demo1.bt.ungdungnghenhac.model.SongRequest;
import com.codegym.demo1.bt.ungdungnghenhac.service.ISongService1;
import com.codegym.demo1.bt.uploadbaihai.SongReal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/bt/ungdungnghenhac")
public class SongController1 {

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private ISongService1 songService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "/bt/ungdungnghenhac/index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("song", new SongRequest());
        return "/bt/ungdungnghenhac/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("song") SongRequest song) {
        MultipartFile multipartFile = song.getLink();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(song.getLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song1 = Song.builder().id(0).name(song.getName()).artist(song.getArtist()).genre(song.getGenre()).link(fileName).build();
        songService.save(song1);
        return "redirect:/bt/ungdungnghenhac";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/bt/ungdungnghenhac/update";
    }

    @PostMapping("/update")
    public String update(SongRequest song) {
        MultipartFile multipartFile = song.getLink();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(song.getLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song1 = Song.builder().name(song.getName()).artist(song.getArtist()).genre(song.getGenre()).link(fileName).build();
        songService.update(song.getId(), song1);
        return "redirect:/bt/ungdungnghenhac";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/bt/ungdungnghenhac/delete";
    }

    @PostMapping("/delete")
    public String delete(SongRequest song, RedirectAttributes redirect) {
        songService.remove(song.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/bt/ungdungnghenhac";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/bt/ungdungnghenhac/view";
    }
}
