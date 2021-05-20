package ru.engineers.AniHelperv1.enteties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "animeauthors")
public class AnimeAuthors {
    @Id
    private int Id;

    @Column(name = "animeid")
    int anime;

    @Column(name = "authorid")
    int author;
}
