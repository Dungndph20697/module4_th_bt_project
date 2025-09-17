package com.codegym.demo1.bt.uploadbaihai;

import com.codegym.demo1.th.uploadfile.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements ISongService<SongReal> {

    private final List<SongReal> songs;

    public SongServiceImpl() {
        songs = new ArrayList<>();
    }

    @Override
    public List<SongReal> findAll() {
        return songs;
    }

    @Override
    public void save(SongReal song) {
        songs.add(song);
    }
}
