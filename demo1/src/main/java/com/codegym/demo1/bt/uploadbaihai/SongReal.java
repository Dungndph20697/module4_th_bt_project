package com.codegym.demo1.bt.uploadbaihai;

import org.springframework.web.multipart.MultipartFile;

public class SongReal {
    private Integer id;
    private String name;
    private String artist;
    private String file;

    public SongReal(Integer id, String name, String artist, String file) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.file = file;
    }

    public SongReal() {
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
