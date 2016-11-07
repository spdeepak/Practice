package com.deepaksp.springboot.ws.repository;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.deepaksp.springboot.model.Greeting;

/**
 * @author Deepak
 *
 */
@Repository
public class GreetingRepositoryDAO extends BaseDAO implements BaseRepository {

    @Override
    public Greeting save(Greeting greeting) {
        currentSession().saveOrUpdate(greeting);
        return null;
    }

    @Override
    public Collection<Greeting> findAll() {
        Criteria crit = createCriteria(Greeting.class, "greet");
        return crit.list();
    }

    @Override
    public Greeting findOne(Long id) {
        Criteria crit = createCriteria(Greeting.class, "greet");
        crit.add(Restrictions.eq("id", id));
        return (Greeting) crit.list().get(0);
    }

    @Override
    public void delete(Long id) {
        Greeting greeting = findOne(id);
        currentSession().delete(greeting);
    }

}
