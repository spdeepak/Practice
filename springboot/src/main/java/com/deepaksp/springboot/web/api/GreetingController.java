package com.deepaksp.springboot.web.api;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deepaksp.springboot.model.Greeting;

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

    private static Greeting save(Greeting greeting) {
        if (greetingMap == null) {
            greetingMap = new HashMap<>();
            nextId = BigInteger.ONE;
        }
        greeting.setId(nextId);
        nextId = nextId.add(BigInteger.ONE);
        greetingMap.put(greeting.getId(), greeting);
        return greeting;
    }

    @RequestMapping(value = "/api/greeting", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Greeting>> getGreeting() {
        Collection<Greeting> greetings = greetingMap.values();
        return new ResponseEntity<>(greetings, HttpStatus.OK);
    }
}
