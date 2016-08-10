package com.movie.ticketing.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CinemaHall implements Common {

    private long id;

    private String name;

    private List<Movie> movie = new ArrayList<>();

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @OneToMany(targetEntity = Movie.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Movie> getMovie() {
        return movie;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }

    public void setName(String name) {
        this.name = name;
    }

}
