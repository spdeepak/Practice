package com.movie.ticketing.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import com.movie.ticketing.model.Movie;

public class MovieDAO extends BaseDAO {

    public List<Movie> movieList() {
        Criteria criteria = createCriteria(Movie.class, "category");
        return criteria.list();
    }

    @Transactional
    public void saveOrUpdate(Movie movie) {
        currentSession().saveOrUpdate(movie);
    }
}
