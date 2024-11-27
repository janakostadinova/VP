package mk.finki.ukim.mk.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    private final AlbumRepository albumRepository;
    List<Song> songs = new ArrayList<>();

    public SongRepository(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @PostConstruct
    private void initializeData() {
        for (int i = 0; i < 5; i++) {
            Song song = new Song("Track" + i, "Title" + i, "Genre" + i, "Release year: " + i);
            song.setAlbum(albumRepository.findAll().get(0));
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

    public Album addAlbumToSong(Album album, Song song){
        song.setAlbum(album);
        return album;
    }

    public Song findSongById(Long songId){
        for (Song s : songs){
            if (s.getId().equals(songId)){
                return s;
            }
        }
        return null;
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public void deleteSong(Long songId){
        for(Song s : songs){
            if (s.getId().equals(songId)){
                songs.remove(s);
                break;
            }
        }
    }
}
