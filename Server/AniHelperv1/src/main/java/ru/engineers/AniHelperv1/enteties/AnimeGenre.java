package ru.engineers.AniHelperv1.enteties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animegenre")
public class AnimeGenre {
    @Id
    private int Id;

    @Column(name = "animeid")
    int anime;

    @Column(name = "genreid")
    int genre;
}
