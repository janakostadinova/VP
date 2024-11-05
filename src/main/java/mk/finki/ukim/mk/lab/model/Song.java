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
    int releaseYear;
    List<Artist> performers = new ArrayList<>();

    public Song(String trackId, String title, String genre, int releaseYear) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}
