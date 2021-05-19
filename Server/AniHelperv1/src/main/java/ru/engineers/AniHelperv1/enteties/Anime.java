package ru.engineers.AniHelperv1.enteties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.List;
import ru.engineers.AniHelperv1.enteties.Genre;

@Entity
@Table(name="anime")
public class Anime {
    @Id
    private int Id;

    private String title;

    private String titleen;

    private String titlehyper;

    private String imghyper;

    private double ratingvalue;

    private String description;

//    @OneToMany(mappedBy="anime")
//    private List<Genre> genres;

}