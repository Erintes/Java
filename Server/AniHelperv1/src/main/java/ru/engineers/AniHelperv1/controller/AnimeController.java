package ru.engineers.AniHelperv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.engineers.AniHelperv1.enteties.Genre;
import ru.engineers.AniHelperv1.services.AnimeService;
import ru.engineers.AniHelperv1.enteties.Anime;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.engineers.AniHelperv1.services.GenreService;

@Controller
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @Autowired
    private GenreService genreService;

    @GetMapping("/animes")
    public String listAll(Model model) {
        List<Anime> listAnime = animeService.getAll();
        List<Genre> genres = genreService.getAll();//do sth
        model.addAttribute("animes", listAnime.subList(0, 10));
        model.addAttribute("genres", genres);
        return "animes";
    }

    @GetMapping("/animes/categorical")
    public String getCategoricalData(@RequestParam String category, Model model){
        List<Anime> animes = animeService.getByGenre(category);
        List<Genre> genres = genreService.getAll(); // do sth
        model.addAttribute("animes", animes.subList(0, Math.min(animes.size(), 10)));
        model.addAttribute("genres", genres);
        return "animes";
    }

    @GetMapping("/anime/{id}")
    public String getAnime(@PathVariable int id, Model model, RedirectAttributes attr){
        Optional<Anime> anime = animeService.getById(id);
        if(anime.isEmpty())
            return "redirect:/error";
        model.addAttribute("item", anime.get());
        return "anime";
    }

}