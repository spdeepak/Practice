package com.movie.ticketing.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CinemaHall implements Common {

    private long id;

    private String name;

    private List<String> showTimings = new ArrayList<>();

    private List<Movie> movies = new ArrayList<>();

    @Override
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    @OneToMany(targetEntity = Movie.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Movie> getMovies() {
        return movies;
    }

    public String getName() {
        return name;
    }

    @ElementCollection(targetClass = String.class)
    public List<String> getShowTimings() {
        return showTimings;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShowTimings(List<String> showTimings) {
        this.showTimings = showTimings;
    }
}
