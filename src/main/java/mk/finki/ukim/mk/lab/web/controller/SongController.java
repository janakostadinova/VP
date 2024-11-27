package mk.finki.ukim.mk.lab.web.controller;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;


    @GetMapping("/songs")
    public String getSongsPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("songs",songService.listSongs());
        return "listSongs";
    }

    @GetMapping("/songs/add")
    public String getSongsAddPage(Model model){
        model.addAttribute("albums",albumService.findAll());
        return "add-song";
    }
//    @GetMapping("/songs/edit/{songId}")
//    public String getSongsEditPage(@PathVariable(name = "songId")Long songId, Model model){
//        model.addAttribute("albums",albumService.findAll());
//        model.addAttribute("song",songService.findSongById(songId));
//        return "add-song";
//    }

    @PostMapping("/songs/add")
    public String saveSong(@RequestParam(name = "title") String title,
                           @RequestParam(name = "trackId") String trackId,
                           @RequestParam(name = "genre") String genre,
                           @RequestParam(name = "releaseYear") String releaseYear,
                           @RequestParam(name = "albumId") Long id) {

        songService.addSong(title,trackId,genre,releaseYear,id);
        return "redirect:/songs";
    }

    @GetMapping("/songs/edit/{songId}")
    public String editSong(@PathVariable Long songId, Model model){
        Song song = songService.findByTrackId(String.valueOf(songId));
        model.addAttribute("song",song);
        return "redirect:/songs";
    }

    @PostMapping("/songs/edit/{songId}")
    public String editSong(@PathVariable(name = "songId") Long songId,
                           @RequestParam(name = "title") String title,
                           @RequestParam(name = "trackId") String trackId,
                           @RequestParam(name = "genre") String genre,
                           @RequestParam(name = "releaseYear") String releaseYear) {
        songService.editSong(songId,title,trackId,genre,releaseYear,songId);
        return "redirect:/songs";
    }


    @GetMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        songService.deleteSong(id);
        return "redirect:/songs";
    }
}
