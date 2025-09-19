package com.codegym.demo1.bt.ungdungnghenhac.service;


import com.codegym.demo1.bt.ungdungnghenhac.model.Song;

import java.util.List;

public interface ISongService1 {

    List<Song> findAll();

    void save(Song song);

    Song findById(Integer id);

    void remove(Integer id);

    void update(Integer id, Song song);

}
