package com.deepaksp.springboot.ws.repository;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.deepaksp.springboot.model.Greeting;

/**
 * @author Deepak
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@SpringBootTest
public class GreetingRepositoryDAOTest {

    @Resource
    private BaseRepository greetingRepositoryImpl;

    @Test
    public void test() {
        System.out.println(greetingRepositoryImpl.findOne(1L).getText());
        Greeting gr = new Greeting();
        gr.setText("Third Text");
        greetingRepositoryImpl.save(gr);
    }

}
