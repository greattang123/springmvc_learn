package com.example.springmvc_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class SpringmvcLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                SpringmvcLearnApplication.class, args);
    }
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}
