package com.movie.ticketing.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import com.movie.ticketing.model.Movie;

public class MovieDAO extends BaseDAO {

    @SuppressWarnings("unchecked")
    public List<Movie> movieList() {
        Criteria crit = createCriteria(Movie.class, "movie");
        return crit.list();
    }

    @Transactional
    public void saveOrUpdate(Movie movie) {
        currentSession().saveOrUpdate(movie);
    }
}
