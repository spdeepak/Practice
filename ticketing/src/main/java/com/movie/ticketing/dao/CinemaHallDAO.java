package com.movie.ticketing.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import com.movie.ticketing.model.CinemaHall;

public class CinemaHallDAO extends BaseDAO {

    @SuppressWarnings("unchecked")
    public List<CinemaHall> cinemaHallList() {
        Criteria criteria = createCriteria(CinemaHall.class, "hall");
        return criteria.list();
    }

    @Transactional
    public void saveOrUpdate(CinemaHall cinemaHall) {
        currentSession().saveOrUpdate(cinemaHall);
    }
}
