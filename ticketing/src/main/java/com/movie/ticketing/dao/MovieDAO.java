package com.movie.ticketing.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.transaction.annotation.Transactional;

import com.movie.ticketing.model.Movie;

public class MovieDAO extends BaseDAO {

    public Movie movieById(long id) {
        Criteria crit = createCriteria(Movie.class, "movie");
        crit.createAlias("movie.cast", "cast", JoinType.LEFT_OUTER_JOIN);
        crit.add(Restrictions.eq("movie.id", id));
        return (Movie) crit.list().get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Movie> movieList() {
        Criteria crit = createCriteria(Movie.class, "movie");
        crit.createAlias("movie.cast", "cast", JoinType.LEFT_OUTER_JOIN);
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return crit.list();
    }

    @Transactional
    public void saveOrUpdate(Movie movie) {
        currentSession().save(movie);
    }
}
