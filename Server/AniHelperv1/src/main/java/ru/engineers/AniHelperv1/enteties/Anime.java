package ru.engineers.AniHelperv1.enteties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="anime")
//@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 5000, allocationSize = 100)
@TableGenerator(name = "AnimeGen", table = "anime", initialValue = 10000, allocationSize = 100)
public class Anime {
    public Anime(String title, String imghyper, double ratingvalue, String description, List<Genre> genres, List<Author> authors) {
        this.title = title;
        this.imghyper = imghyper;
        this.titleen = "";
        this.ratingvalue = ratingvalue;
        this.description = description;
        this.genres = genres;
        this.authors = authors;
    }

//    @TableGenerator(name = "AnimeGen", table = "anime", initialValue = 10000, allocationSize = 100)
//    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGen")
//    @Column(columnDefinition = "serial")
    private int id;

    private String title;

    private String titleen;

    private String titlehyper;

    private String imghyper;

    private double ratingvalue;

    @Column(length = 4000)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "animegenre",
            joinColumns = @JoinColumn(name = "animeid"),
            inverseJoinColumns = @JoinColumn(name = "genreid"))
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "animeauthors",
            joinColumns = @JoinColumn(name = "animeid"),
            inverseJoinColumns = @JoinColumn(name = "authorid"))
    private List<Author> authors;

    public Anime() {

    }

    public int getId() {
        return id;
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