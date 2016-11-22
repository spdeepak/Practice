package com.deepaksp.springboot.ws.service;

import java.util.Collection;

import com.deepaksp.springboot.model.Greeting;

public interface GreetingService {

    Greeting create(Greeting greeting);

    void delete(Long id);

    Collection<Greeting> findAll();

    Greeting findOne(Long id);

    Greeting update(Greeting greeting);

    void evictCache();
}
