package com.deepaksp.springboot.ws.batch;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.deepaksp.springboot.model.Greeting;
import com.deepaksp.springboot.ws.service.GreetingService;

/**
 * @author Deepak
 *
 */
@Component
public class GreetingBatchBean {

    private Logger logger = LoggerFactory.getLogger(GreetingBatchBean.class);

    @Autowired
    private GreetingService greetingService;

    @Scheduled(cron = "0,30 * * * * *")
    public void cronJob() {
        logger.info("<cron job");
        Collection<Greeting> greetings = greetingService.findAll();
        logger.info("There are {} greetings in the data store", greetings.size());
        logger.info("cron job>");
    }

    @Scheduled(initialDelay = 5000, fixedRate = 15000)
    public void fixedRateJobWithInitialDelay() {
        logger.info("<fixedRateJObWithInitialDelay");
        long pause = 5000;
        long start = System.currentTimeMillis();
        do {
            if (start + pause < System.currentTimeMillis()) {
                break;
            }
        } while (true);
        logger.info("Processing time was {} seconds", pause / 1000);
        logger.info(">fixedRateJObWithInitialDelay");
    }

    //    @Scheduled(initialDelay = 5000, fixedDelay = 15000)
    public void fixedDelayJobWithInitialDelay() {
        logger.info("<fixedDelayJObWithInitialDelay");
        long pause = 5000;
        long start = System.currentTimeMillis();
        do {
            if (start + pause < System.currentTimeMillis()) {
                break;
            }
        } while (true);
        logger.info("Processing time was {} seconds", pause / 1000);
        logger.info(">fixedDelayJObWithInitialDelay");
    }
}
