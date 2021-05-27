package ru.engineers.AniHelperv1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.engineers.AniHelperv1.enteties.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
