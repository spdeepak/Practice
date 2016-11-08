package com.deepaksp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Run this class and open a web browser to localhost:8080
 * 
 * @author Deepak
 *
 */
@RestController
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

}