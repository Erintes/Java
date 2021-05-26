package ru.engineers.AniHelperv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.engineers.AniHelperv1.services.AnimeService;
import ru.engineers.AniHelperv1.enteties.Anime;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @GetMapping("/animes")
    public String listAll(Model model) {
        List<Anime> listAnime = animeService.getAll();
        model.addAttribute("listAnime", listAnime);

        return "animes";
    }

}