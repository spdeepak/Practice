package com.movie.ticketing.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.movie.ticketing.model.Cast;
import com.movie.ticketing.model.CinemaHall;
import com.movie.ticketing.model.Movie;
import com.movie.ticketing.model.Type;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class TestApp {

    @Resource
    private MovieDAO movieDAO;

    @Resource
    private CastDAO castDAO;

    @Resource
    private CinemaHallDAO cinemaHallDAO;

    @Test
    @Transactional
    public void test() {
        //Creating a movie
        Movie movie = new Movie();
        movie.setMovieName("Movie One");
        movie.setPlot("Sample Plot");
        movie.setReleaseDate(new Date(20160101L));
        //Creating cast
        Cast cast1 = new Cast("male", "lead", Type.MALE_LEAD);
        Cast cast2 = new Cast("female", "lead", Type.FEMALE_LEAD);
        castDAO.saveOrUpdate(cast1);
        castDAO.saveOrUpdate(cast2);
        List<Cast> cast = new ArrayList<>();
        cast.add(cast1);
        cast.add(cast2);
        //adding cast to movie
        movie.setCast(cast);
        movie.setRuntime(120);
        movieDAO.saveOrUpdate(movie);

        CinemaHall ch = new CinemaHall();
        ch.setMovies(new ArrayList<Movie>() {

            {
                add(movie);
            }
        });
        ch.setName("Odeon");
        ch.setShowTimings(new ArrayList<String>() {

            {
                add("10:00AM");
                add("1:00PM");
                add("4:00PM");
            }
        });
        cinemaHallDAO.saveOrUpdate(ch);
    }
}
