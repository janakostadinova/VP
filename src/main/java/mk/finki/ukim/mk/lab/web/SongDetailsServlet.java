package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "SongDetailsServlet", urlPatterns = "/songDetails")
@AllArgsConstructor

public class SongDetailsServlet extends HttpServlet {

    private final SongService songService;
    private final SpringTemplateEngine springTemplateEngine;
    private final ArtistService artistService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        String trackId = req.getParameter("trackId");
        Long artistId = Long.parseLong(req.getParameter("artistId"));

        Artist artist = artistService.findById(artistId);
        Song song = songService.findByTrackId(trackId);

        songService.addArtistToSong(artist,song);

        context.setVariable("song", song);

        springTemplateEngine.process("songDetails.html", context, resp.getWriter());
    }
}
