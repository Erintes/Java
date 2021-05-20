package ru.engineers.AniHelperv1.enteties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animegenre")
public class Genre {
    @Id
    private int Id;

    @Column(name="animeid")
    private int animeid;

    @Column(name="genre")
    public String genre;
}