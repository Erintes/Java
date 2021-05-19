package ru.engineers.AniHelperv1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.engineers.AniHelperv1.enteties.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {
}