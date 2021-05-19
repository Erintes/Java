package ru.engineers.AniHelperv1.enteties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.Table;

public class Genre {
    @Id
    private int Id;

    @ManyToOne
    @JoinColumn(name="animeid")
    private int anime;

    @Column(name="genre")
    private String genre;
}