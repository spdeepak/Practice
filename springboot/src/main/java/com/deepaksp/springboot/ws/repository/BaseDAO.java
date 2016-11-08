package com.deepaksp.springboot.ws.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Deepak
 *
 */
@Repository
@Transactional
public class BaseDAO {

    @Autowired
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
