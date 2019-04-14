package com.example.springmvc_learn.example6_test;

import com.example.springmvc_learn.example6.timer.Timer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimerTest {
    @Autowired
    private Timer timer;
    @Test
    public void test(){
        timer.welcome();
    }
}
