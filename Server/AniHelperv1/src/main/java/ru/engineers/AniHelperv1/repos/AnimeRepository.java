package ru.engineers.AniHelperv1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.engineers.AniHelperv1.enteties.Anime;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {
    @Query(value="select * from anime where id in (select animeid from animegenre a inner join genre g on a.genreid = g.id where g.name=?1)", nativeQuery = true)
    List<Anime> findAllByGenreName(String genre);

    @Query(value="select * from anime where id in (select animeid from animegenre a where a.genreid=?1)", nativeQuery = true)
    List<Anime> findAllByGenreId(int genreId);
}