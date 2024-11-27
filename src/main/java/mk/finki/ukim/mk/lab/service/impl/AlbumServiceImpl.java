package mk.finki.ukim.mk.lab.service.impl;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.repository.AlbumRepository;
import mk.finki.ukim.mk.lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }


}
