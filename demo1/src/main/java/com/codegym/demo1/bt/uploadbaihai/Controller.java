package com.codegym.demo1.bt.uploadbaihai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@org.springframework.stereotype.Controller
@RequestMapping("/bt/song")
public class Controller {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private final ISongService songService;

    public Controller(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "/bt/song/index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("song", new Song());
        return "/bt/song/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("song") Song song) {
        MultipartFile multipartFile = song.getFile();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(song.getFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        SongReal song1 = new SongReal(song.getId(),song.getName(),song.getArtist(),fileName);
        song.setId((int) (Math.random() * 10000));
        songService.save(song1);
        return "redirect:/bt/song";
    }
}
