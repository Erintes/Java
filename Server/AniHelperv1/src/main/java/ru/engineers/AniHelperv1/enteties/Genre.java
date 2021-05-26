package ru.engineers.AniHelperv1.enteties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    private int Id;

    public int getId() {
        return this.Id;
    }

    @Column(name="name")
    private String genre;

    public String getGenre() {
        return this.genre;
    }
}