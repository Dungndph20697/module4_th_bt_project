package com.codegym.validatesong.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Song {
    private Integer id;

    @NotBlank
    @Size(max = 800)
    @Pattern(
            regexp = "^[a-zA-Z0-9\\s]+$",
            message = "Không được chứa ký tự đặc biệt"
    )
    private String name;

    @NotBlank
    @Size(max = 300)
    @Pattern(
            regexp = "^[a-zA-Z0-9\\s]+$",
            message = "Không được chứa ký tự đặc biệt"
    )
    private String artist;

    @NotBlank
    @Size(max = 1000)
    @Pattern(
            regexp = "^[a-zA-Z0-9\\s,]+$",
            message = "Không được chứa ký tự đặc biệt"
    )
    private String genre;

    public Song(Integer id, String name, String artist, String genre) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
