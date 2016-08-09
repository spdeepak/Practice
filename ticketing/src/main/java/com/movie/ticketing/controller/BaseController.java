package com.movie.ticketing.controller;

import java.util.List;

import com.movie.ticketing.dao.MovieDAO;
import com.movie.ticketing.model.Movie;

public class BaseController {

    private MovieDAO movieDAO;

    public List<Movie> movieList() {
        return movieDAO.movieList();
    }

    public void setMovieDAO(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }
}
