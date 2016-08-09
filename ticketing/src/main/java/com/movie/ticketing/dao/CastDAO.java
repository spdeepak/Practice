package com.movie.ticketing.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import com.movie.ticketing.model.Cast;

public class CastDAO extends BaseDAO {

    public List<Cast> castBasedOnMovieName(String movieName) {
        Criteria criteria = createCriteria(Cast.class, "category");
        return criteria.list();
    }

    @Transactional
    public void saveOrUpdate(Cast cast) {
        currentSession().saveOrUpdate(cast);
    }
}
