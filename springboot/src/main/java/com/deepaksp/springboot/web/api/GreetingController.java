package com.deepaksp.springboot.web.api;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deepaksp.springboot.model.Greeting;

/**
 * Run the Spring Boot application and see http://localhost:8080/api/greeting for the output
 * 
 * @author Deepak
 *
 */
@RestController
public class GreetingController {

    private static BigInteger nextId;

    private static Map<BigInteger, Greeting> greetingMap;

    static {
        Greeting g1 = new Greeting();
        g1.setText("text one");
        save(g1);
        Greeting g2 = new Greeting();
        g2.setText("text two");
        save(g2);
    }

    private static boolean delete(BigInteger id) {
        Greeting deleteGreet = greetingMap.remove(id);
        if (deleteGreet == null) {
            return false;
        }
        return true;
    }

    private static Greeting save(Greeting greeting) {
        if (greetingMap == null) {
            greetingMap = new HashMap<>();
            nextId = BigInteger.ONE;
        }
        //If update
        if (greeting.getId() != null) {
            Greeting oldGreet = greetingMap.get(greeting.getId());
            if (oldGreet == null) {
                return null;
            }
            greetingMap.remove(greeting.getId());
            greetingMap.put(greeting.getId(), greeting);
            return greeting;
        }
        //If Create
        greeting.setId(nextId);
        nextId = nextId.add(BigInteger.ONE);
        greetingMap.put(greeting.getId(), greeting);
        return greeting;
    }

    @RequestMapping(value = "/api/greetings", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> createGreeting(@RequestBody Greeting greeting) {
        Greeting greet = save(greeting);
        return new ResponseEntity<>(greet, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/greetings/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> deleteGreeting(@PathVariable("id") BigInteger id, @RequestBody Greeting greeting) {
        boolean delete = delete(id);
        if (!delete) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/api/greeting", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Greeting>> getGreeting() {
        Collection<Greeting> greetings = greetingMap.values();
        return new ResponseEntity<>(greetings, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/greeting/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> getGreeting(@PathVariable("id") BigInteger id) {
        Greeting greeting = greetingMap.get(id);
        if (greeting != null) {
            return new ResponseEntity<>(greeting, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/api/greetings/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> updateGreeting(@RequestBody Greeting greeting) {
        Greeting updatedGreet = save(greeting);
        if (updatedGreet == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(updatedGreet, HttpStatus.OK);
    }
}
