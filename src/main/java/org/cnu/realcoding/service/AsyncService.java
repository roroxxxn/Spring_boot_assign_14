package org.cnu.realcoding.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@EnableAsync
@Slf4j
public class AsyncService {
    AtomicLong counter = new AtomicLong();
    @Async
    public void increaseCounter() {
        for(int  i = 0; i < 100000; i++){
            long count = counter.incrementAndGet();
            log.info("count: {}",count);
        }
    }
}
