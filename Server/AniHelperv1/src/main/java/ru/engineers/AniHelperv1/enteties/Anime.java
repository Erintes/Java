package ru.engineers.AniHelperv1.enteties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="anime")
public class Anime {
    public Anime(String title, double ratingvalue, String description, List<Genre> genres) {
        this.Id = 13000 + 1;
        this.title = title;
        this.titleen = "";
        this.ratingvalue = ratingvalue;
        this.description = description;
        this.genres = genres;
    }

    public void setId(int id) {
        Id = id;
    }

    @Id
    private int Id;

    private String title;

    private String titleen;

    private String titlehyper;

    private String imghyper;

    private double ratingvalue;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "animegenre",
            joinColumns = @JoinColumn(name = "genreid"),
            inverseJoinColumns = @JoinColumn(name = "animeid"))
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "animeauthors",
            joinColumns = @JoinColumn(name = "authorid"),
            inverseJoinColumns = @JoinColumn(name = "animeid"))
    private List<Author> authors;

    public Anime() {

    }

    public int getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getImghyper() {
        return imghyper;
    }

    public double getRatingvalue() {
        return ratingvalue;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImghyper(String imghyper) {
        this.imghyper = imghyper;
    }

    public void setRatingvalue(double ratingvalue) {
        this.ratingvalue = ratingvalue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}