package com.example.springmvc_learn.example6.timer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Timer {
    @Scheduled(cron ="*/3 * * * * *")
    public void welcome(){
        log.debug("Welcome!");
    }
}
