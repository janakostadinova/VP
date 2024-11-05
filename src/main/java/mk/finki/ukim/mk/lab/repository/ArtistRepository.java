package mk.finki.ukim.mk.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    List<Artist> artists = new ArrayList<>();


    @PostConstruct
    private void initializeData() {
        for (int i = 0; i < 5; i++) {
            Artist artist = new Artist((long) i, "Name" + i, "Surname" + i, "Bio" + i);
            artists.add(artist);
        }
    }

    public List<Artist> findAll(){
        return artists;
    }

    public Optional<Artist> findById(Long id){
        for (Artist artist : artists){
            if (artist.getId().equals(id)){
                return Optional.of(artist);
            }
        }
        return Optional.empty();
    }

}
