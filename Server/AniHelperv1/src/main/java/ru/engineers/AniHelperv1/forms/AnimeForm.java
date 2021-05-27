package ru.engineers.AniHelperv1.forms;


import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class AnimeForm {
    private String title;

    private MultipartFile imghyper;

    private double ratingvalue;

    private String description;

    private int authors;

    private int roles;

    private List<Integer> genres;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getImghyper() {
        return imghyper;
    }

    public void setImghyper(MultipartFile imghyper) {
        this.imghyper = imghyper;
    }

    public double getRatingvalue() {
        return ratingvalue;
    }

    public void setRatingvalue(double ratingvalue) {
        this.ratingvalue = ratingvalue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthors(int authors) {
        this.authors = authors;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    public void setGenres(List<Integer> genres) {
        this.genres = genres;
    }

    public int getAuthors() {
        return authors;
    }

    public int getRoles() {
        return roles;
    }

    public List<Integer> getGenres() {
        return genres;
    }
}
