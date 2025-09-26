package com.codegym.validatesong.service;

import com.codegym.validatesong.model.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongService {
    private Map<Integer, Song> songs;

    public SongService() {
        songs = new HashMap();
        songs.put(1, new Song(1, "aaaaa", "aaaaaa", "aaaaaaa"));
//        songs.add(new Song(1,"aaaaa", "aaaaaa", "aaaaaaa"));
    }

    public List<Song> getSongs() {
        return new ArrayList<>(songs.values());
    }

    public void addSong(Song song) {
        songs.put(song.getId(), song);
    }

    public void update(Integer id, Song song) {
        songs.put(id, song);
    }

    public Song getSong(Integer id) {
        return songs.get(id);
    }
}
