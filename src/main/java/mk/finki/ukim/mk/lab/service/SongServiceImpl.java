package mk.finki.ukim.mk.lab.service;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService{

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
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
}
