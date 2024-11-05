package mk.finki.ukim.mk.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    List<Song> songs = new ArrayList<>();


    @PostConstruct
    private void initializeData() {
        for (int i = 0; i < 5; i++) {
            Song song = new Song("Track" + i, "Title" + i, "Genre" + i, i);
            songs.add(song);
        }
    }

    public List<Song> findAll() {
        return songs;
    }

    public Song findByTrackId(String trackId) {
        for (Song song : songs) {
            if (song.getTrackId().equals(trackId)) {
                return song;
            }
        }
        return null;
    }

    public Artist addArtistToSong(Artist artist, Song song) {
        song.getPerformers().add(artist);
        return artist;
    }
}
