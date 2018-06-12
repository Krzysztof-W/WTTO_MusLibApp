package com.kwarzecha.MusLibApp.web;

import com.kwarzecha.MusLibApp.model.Artist;
import com.kwarzecha.MusLibApp.repositories.ArtistRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtistsController {

    private final ArtistRepository artistsRepository;

    public ArtistsController(ArtistRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }

    @GetMapping("/artists")
    public String getArtists(Model model) {
        Iterable<Artist> artists = artistsRepository.findAll();
        model.addAttribute("artists", artists);
        return "artists";
    }
}
