package com.bztf.springProject.Models;

import jakarta.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private int releaseYear;
    private String description;
    private boolean watched;

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Regisseur regisseur;

    // Getters und Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Regisseur getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(Regisseur regisseur) {
        this.regisseur = regisseur;
    }
}
