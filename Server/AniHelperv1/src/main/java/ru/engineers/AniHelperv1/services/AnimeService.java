package ru.engineers.AniHelperv1.services;

import ru.engineers.AniHelperv1.enteties.Anime;
import ru.engineers.AniHelperv1.repos.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    @Autowired
    private AnimeRepository animeRepo;

//    public Anime getById(int id) {
//        return animeRepo.findById(id);
//    }

    public List<Anime> getAll() {
        return animeRepo.findAll();
    }
}