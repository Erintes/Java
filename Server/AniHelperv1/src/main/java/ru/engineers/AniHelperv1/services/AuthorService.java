package ru.engineers.AniHelperv1.services;

import ru.engineers.AniHelperv1.enteties.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.engineers.AniHelperv1.repos.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepo;

//    public Anime getById(int id) {
//        return animeRepo.findById(id);
//    }

    public List<Author> getAll() {
        return authorRepo.findAll();
    }
}
