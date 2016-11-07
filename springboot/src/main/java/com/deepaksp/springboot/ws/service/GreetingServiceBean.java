package com.deepaksp.springboot.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepaksp.springboot.model.Greeting;
import com.deepaksp.springboot.ws.repository.BaseRepository;

@Service
public class GreetingServiceBean implements GreetingService {

    @Autowired
    private BaseRepository greetingRepository;

    @Override
    public Greeting create(Greeting greeting) {
        Greeting greet = (Greeting) greetingRepository.save(greeting);
        return greet;
    }

    @Override
    public void delete(Long id) {
        greetingRepository.delete(id);
    }

    @Override
    public Collection<Greeting> findAll() {
        Collection<Greeting> greetings = greetingRepository.findAll();
        return greetings;
    }

    @Override
    public Greeting findOne(Long id) {
        Greeting greeting = (Greeting) greetingRepository.findOne(id);
        return greeting;
    }

    @Override
    public Greeting update(Greeting greeting) {
        Greeting updatedGreet = (Greeting) greetingRepository.save(greeting);
        return updatedGreet;
    }
}
