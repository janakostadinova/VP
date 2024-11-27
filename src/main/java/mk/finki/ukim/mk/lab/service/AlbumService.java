package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;

public interface AlbumService {
    List<Album> findAll();
}
