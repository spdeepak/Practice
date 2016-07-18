package com.deepaksp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Run this class and open a web browser to localhost:8080
 * 
 * @author Deepak
 *
 */
@RestController
@EnableAutoConfiguration
public class Example {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

}