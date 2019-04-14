package com.example.springmvc_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class SpringmvcLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                SpringmvcLearnApplication.class, args);
    }
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
    /*需添加 <groupId>org.springframework.security</groupId>
               <artifactId>spring-security-crypto</artifactId> 依赖*/
   //直接注入编码组件
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
