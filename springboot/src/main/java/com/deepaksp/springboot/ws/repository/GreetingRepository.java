package com.deepaksp.springboot.ws.repository;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.deepaksp.springboot.model.Greeting;

/**
 * @author Deepak
 *
 */
@Repository
public interface GreetingRepository {

    Greeting save(Greeting greeting);

    Collection<Greeting> findAll();

    Greeting findOne(Long id);

    void remove(Long id);

}
