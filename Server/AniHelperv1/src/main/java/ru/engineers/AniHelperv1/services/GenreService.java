package ru.engineers.AniHelperv1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.engineers.AniHelperv1.enteties.Genre;
import ru.engineers.AniHelperv1.repos.GenreRepository;

import java.util.List;
import java.util.Optional;


@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepo;

    public List<Genre> getAll() {
        return genreRepo.findAll();
    }
    public Optional<Genre> getById(int id) {return genreRepo.findById(id);}
}