package com.movie.ticketing.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.movie.ticketing.model.Movie;

public class MovieDAO extends BaseDAO {

    public Movie movieById(long id) {
        Criteria crit = createCriteria(Movie.class, "movie");
        crit.add(Restrictions.eq("movie.id", id));
        return (Movie) crit.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Movie> movieList() {
        Criteria crit = createCriteria(Movie.class, "movie");
        return crit.list();
    }

    @Transactional
    public void saveOrUpdate(Movie movie) {
        currentSession().save(movie);
    }
}
