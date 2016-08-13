package com.movie.ticketing.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.movie.ticketing.dao.CinemaHallDAO;
import com.movie.ticketing.dao.MovieDAO;
import com.movie.ticketing.model.CinemaHall;
import com.movie.ticketing.model.Movie;

@Controller("controller")
@SessionScoped
@ManagedBean(name = "controller")
public class BaseController {

    @Autowired
    private MovieDAO movieDAO;

    @Autowired
    private CinemaHallDAO cinemaHallDAO;

    public List<CinemaHall> cinemaHallList() {
        return cinemaHallDAO.cinemaHallList();
    }

    public Movie movieById(long id) {
        return movieDAO.movieById(id);
    }

    public String movieInfo() {
        return "movieInfo";
    }

    public List<Movie> movieList() {
        return movieDAO.movieList();
    }
}
