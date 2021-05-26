package ru.engineers.AniHelperv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import ru.engineers.AniHelperv1.FS.FileUploadUtil;
import ru.engineers.AniHelperv1.enteties.Genre;
import ru.engineers.AniHelperv1.enteties.Anime;
import ru.engineers.AniHelperv1.enteties.Author;
import ru.engineers.AniHelperv1.enteties.Role;

import ru.engineers.AniHelperv1.forms.AnimeForm;
import ru.engineers.AniHelperv1.services.AnimeService;
import ru.engineers.AniHelperv1.services.GenreService;
import ru.engineers.AniHelperv1.services.AuthorService;
import ru.engineers.AniHelperv1.services.RoleService;

@Controller
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/animes")
    public String listAll(Model model) {
        List<Anime> listAnime = animeService.getAll();
        List<Genre> genres = genreService.getAll();

        model.addAttribute("animes", listAnime.subList(0, 10));
        model.addAttribute("genres", genres);
        return "animes";
    }

    @GetMapping("/animes/categorical")
    public String getCategoricalData(@RequestParam(required = false) Integer genreId, Model model){

        List<Genre> genres = genreService.getAll();
        if(genreId == null || genres.stream().noneMatch(genre -> genre.getId() == genreId))
            return "error";

        List<Anime> animes = animeService.getByGenreId(genreId);

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

    @GetMapping("/anime/add")
    public String addNewAnime(Model model){
        List<Genre> genres = genreService.getAll();
        List<Author> authors = authorService.getAll();
        List<Role> roles = roleService.getAll();
        AnimeForm anime = new AnimeForm();

        model.addAttribute("genres", genres);
        model.addAttribute("authors", authors);
        model.addAttribute("roles", roles);
        model.addAttribute("anime", anime);

        return "addanime";
    }

    @PostMapping("/add")
    public String submitForm(@ModelAttribute("anime") AnimeForm anime) {
//        animeService.save(fromForm(anime));
        return "redirect:/animes";
    }

    private Anime fromForm(AnimeForm form) {
        List<Genre> genres = new ArrayList<>();
        form.getGenres().forEach(id -> genres.add(genreService.getById(id).get()));
        return new Anime(
            form.getTitle(),
            form.getRatingvalue(),
            form.getDescription(),
            genres
        );
    }
}