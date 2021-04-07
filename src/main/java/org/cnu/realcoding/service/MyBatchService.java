package org.cnu.realcoding.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@Slf4j
public class MyBatchService {

   @Autowired
   AsyncService asyncService;
   int counter = 0;

 //   @Scheduled(fixedDelay = 1000L)
    public void count() {
        log.info("count: {}", counter++);
        if(counter < 10){
            asyncService.increaseCounter();
        }
    }
}
