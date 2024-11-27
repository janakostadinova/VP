package mk.finki.ukim.mk.lab.service.impl;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.AlbumRepository;
import mk.finki.ukim.mk.lab.repository.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.Event;

import java.util.List;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    private final AlbumRepository albumRepository;
    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        Song existingSong = songRepository.findByTrackId(song.getTrackId());
        if (existingSong != null) {
            existingSong.getPerformers().add(artist);
            return artist;
        }
        return null;
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public void addSong(String title, String trackId, String genre, String releaseYear, Long id) {
        Album album = albumRepository.findAlbumById(id);
        Song song = new Song(trackId,title,genre,releaseYear);
        song.setAlbum(album);
        songRepository.addSong(song);
    }

    @Override
    public void editSong(Long songId, String title, String trackId, String genre, String releaseYear, Long id) {
        Song song = songRepository.findSongById(songId);
        Album album = albumRepository.findAlbumById(id);
        song.setTitle(title);
        song.setTrackId(trackId);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(album);
    }

    @Override
    public void deleteSong(Long songId) {
        songRepository.deleteSong(songId);
    }

    @Override
    public Song findSongById(Long songId) {
        return songRepository.findSongById(songId);
    }


}
