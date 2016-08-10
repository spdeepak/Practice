package com.movie.ticketing.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseDAO {

    private SessionFactory sessionFactory;

    public Criteria createCriteria(Class<?> clazz, String alias) {
        return currentSession().createCriteria(clazz, alias);
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
