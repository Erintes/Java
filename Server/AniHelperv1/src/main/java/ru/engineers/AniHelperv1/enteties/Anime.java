package ru.engineers.AniHelperv1.enteties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="anime")
public class Anime {
    @Id
    public int Id;

    public String title;

    private String titleen;

    private String titlehyper;

    public String imghyper;

    public double ratingvalue;

    public String description;

    @ManyToMany
    @JoinTable(
            name = "animegenre",
            joinColumns = @JoinColumn(name = "genreid"),
            inverseJoinColumns = @JoinColumn(name = "animeid"))
    public List<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "animeauthors",
            joinColumns = @JoinColumn(name = "authorid"),
            inverseJoinColumns = @JoinColumn(name = "animeid"))
    public List<Author> authors;
}