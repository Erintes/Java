package ru.engineers.AniHelperv1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.engineers.AniHelperv1.enteties.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
