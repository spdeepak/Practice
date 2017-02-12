package com.deepak.springboot.hello;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Deepak
 *
 */
@RestController
public class HelloController {

    @RequestMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHi() {
        return "Hi";
    }
}
