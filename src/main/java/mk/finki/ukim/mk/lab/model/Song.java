package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Song {
    String trackId;
    String title;
    String genre;
    String releaseYear;
    List<Artist> performers = new ArrayList<>();
    private Long id;
    private Album album;

    public Song(String trackId, String title, String genre, String releaseYear) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.id = (long) (Math.random() * 1000);
    }
}
