package ru.engineers.AniHelperv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.engineers.AniHelperv1.services.AnimeService;
import ru.engineers.AniHelperv1.enteties.Anime;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @GetMapping("/animes/")
    public String listAll(Model model) {
        List<Anime> listAnime = animeService.getAll();
        model.addAttribute("animes", listAnime.subList(0, 50));
//        Anime anime = listAnime.get(10);
//        model.addAttribute("item", anime);


        return "animes";
    }
//
//    @GetMapping("/animes/categorical/")
//    public String getCategoricalData(Model model){
//        List<Anime> animes = animeService.getByGenre("Военное");
//        model.addAttribute("animes", animes.subList(0, Math.min(animes.size(), 50)));
//        return "anime";
//    }

    @GetMapping("/anime/{id}")
    public String getAnime(@PathVariable int id, Model model, RedirectAttributes attr){
        Optional<Anime> anime = animeService.getById(id);
        if(anime.isEmpty())
            return "redirect:/error";
        model.addAttribute("item", anime.get());
        return "anime";
    }

}