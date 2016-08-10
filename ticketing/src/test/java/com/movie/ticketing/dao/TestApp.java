package com.movie.ticketing.dao;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movie.ticketing.model.Cast;
import com.movie.ticketing.model.CinemaHall;
import com.movie.ticketing.model.DateUtils;
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

    @SuppressWarnings("serial")
    @Test
    //    @Transactional
    public void test() throws ParseException {
        //Creating a movie
        Movie movie1 = new Movie();
        movie1.setMovieName("Movie One");
        movie1.setPlot("Sample Plot1");
        movie1.setReleaseDate(new Date(DateUtils.dateToMilliSecondsConverter(20160101L)));
        //Creating cast
        Cast cast1 = new Cast("male", "lead", Type.MALE_LEAD);
        Cast cast2 = new Cast("female", "lead", Type.FEMALE_LEAD);
        castDAO.saveOrUpdate(cast1);
        castDAO.saveOrUpdate(cast2);
        List<Cast> cast = new ArrayList<>();
        cast.add(cast1);
        cast.add(cast2);
        //adding cast to movie
        movie1.setCast(cast);
        movie1.setRuntime(120);
        movieDAO.saveOrUpdate(movie1);

        //Creating a movie
        Movie movie2 = new Movie();
        movie2.setMovieName("Movie Two");
        movie2.setPlot("Sample Plot2");
        movie2.setReleaseDate(new Date(DateUtils.dateToMilliSecondsConverter(20160101L)));
        movie2.setRuntime(120);
        movieDAO.saveOrUpdate(movie2);

        CinemaHall ch = new CinemaHall();
        ch.setName("Odeon");
        ch.setMovie(new ArrayList<Movie>() {

            {
                add(movie1);
                add(movie2);
            }
        });
        cinemaHallDAO.saveOrUpdate(ch);
    }
}
