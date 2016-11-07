package com.deepaksp.springboot.ws.repository;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Deepak
 *
 */
@Repository
@Transactional
public interface BaseRepository<T> {

    T save(T t);

    Collection<T> findAll();

    T findOne(Long id);

    void delete(Long id);

}
