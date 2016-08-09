package com.movie.ticketing.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import com.movie.ticketing.model.CinemaHall;
import com.movie.ticketing.model.Movie;

public class CinemaHallDAO extends BaseDAO {

    public List<Movie> cinemaHallList() {
        Criteria criteria = createCriteria(CinemaHall.class, "category");
        return criteria.list();
    }

    @Transactional
    public void saveOrUpdate(CinemaHall cinemaHall) {
        currentSession().saveOrUpdate(cinemaHall);
    }
}
