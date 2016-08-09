package com.movie.ticketing.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Movie implements Common {

    private long id;

    private String movieName;

    private Date releaseDate;

    private List<Cast> Cast = new ArrayList<>();

    private String plot;

    private Integer runtime;

    @OneToMany(targetEntity = Cast.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Cast> getCast() {
        return Cast;
    }

    @Override
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getPlot() {
        return plot;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setCast(List<Cast> cast) {
        Cast = cast;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * In Minutes
     * 
     * @param runtime
     */
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }
}
