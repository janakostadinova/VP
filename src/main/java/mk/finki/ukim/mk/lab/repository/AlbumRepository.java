package mk.finki.ukim.mk.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {
    List<Album> albums = new ArrayList<>();


    @PostConstruct
    private void initializeData() {
        for (int i = 0; i < 5; i++) {
            Album album = new Album("Name" + i, "Genre" + i, "Release year" + i);
            albums.add(album);
        }
    }

    public List<Album> findAll() {
        return albums;
    }

    public Album findAlbumById(Long id){
        for (Album a : albums){
            if (a.getId().equals(id)){
                return a;
            }
        }
        return null;
    }
}
