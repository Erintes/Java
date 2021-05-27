package ru.engineers.AniHelperv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.lang.module.Configuration;
import java.nio.file.FileSystem;
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

import javax.swing.*;

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

    @GetMapping("/animes/search")
    public String search(@PathVariable String field, Model model){
        List<Anime> listAnime = animeService.getAll();
        List<Genre> genres = genreService.getAll();

        model.addAttribute("animes", listAnime.subList(0, 10));
        model.addAttribute("genres", genres);
        return "animes";
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
    public String submitForm(@ModelAttribute("anime") AnimeForm anime, Model model) throws IOException {
        Anime newAnime = fromForm(anime);
//        animeService.save(newAnime);
//        return "redirect:/animes";
        model.addAttribute("item", newAnime);

        return "anime";
    }

    private Anime fromForm(AnimeForm form) throws IOException {
        List<Genre> genres = new ArrayList<>();
        form.getGenres().forEach(id -> genres.add(genreService.getById(id).get()));

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(form.getImghyper().getOriginalFilename()));
        String uploadDir = "user-photos/" + form.getTitle();
        FileUploadUtil.saveFile(uploadDir, fileName, form.getImghyper());

        Role role = roleService.getById(form.getRoles()).get();
        Author author = authorService.getById(form.getAuthors()).get();
        author.setRoles(List.of(role));
        return new Anime(
                form.getTitle(),
                String.format("%s/%s/", uploadDir, fileName),
                form.getRatingvalue(),
                form.getDescription(),
                genres,
                List.of(author)
        );
    }
}