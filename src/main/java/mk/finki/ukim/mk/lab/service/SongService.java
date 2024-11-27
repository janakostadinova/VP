package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.w3c.dom.events.Event;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findByTrackId(String trackId);

    void addSong(String title,String trackId, String genre, String releaseYear, Long id);
    void editSong(Long songId, String title,String trackId, String genre, String releaseYear, Long id);
    void deleteSong(Long songId);
    Song findSongById(Long songId);
}
