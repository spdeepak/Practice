package com.deepaksp.springboot.ws.repository;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deepaksp.springboot.model.Greeting;

/**
 * @author Deepak
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class GreetingRepositoryDAOTest {

    @Resource
    private BaseRepository greetingRepositoryImpl;

    @Test
    public void test() {
        System.out.println(((Greeting) greetingRepositoryImpl.findOne(1L)).getText());
        Greeting gr = new Greeting();
        gr.setText("Third Text");
        greetingRepositoryImpl.save(gr);
    }

}
