package com.deepaksp.springboot.ws.repository;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.deepaksp.springboot.model.Greeting;

/**
 * @author Deepak
 *
 */
//@Repository
@Transactional
public interface BaseRepository {

    Greeting save(Greeting greeting);

    Collection<Greeting> findAll();

    Greeting findOne(Long id);

    void delete(Long id);

}
