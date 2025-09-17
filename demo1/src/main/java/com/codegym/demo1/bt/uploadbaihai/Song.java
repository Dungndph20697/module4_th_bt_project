package com.codegym.demo1.bt.uploadbaihai;

import org.springframework.web.multipart.MultipartFile;

public class Song {
    private Integer id;
    private String name;
    private String artist;
    private MultipartFile file;

    public Song(Integer id, String name, String artist, MultipartFile file) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.file = file;
    }

    public Song() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
