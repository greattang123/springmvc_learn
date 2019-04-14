package com.example.springmvc_learn;

import com.example.springmvc_learn.example5.interceptor.interceptor.LoginInterceptor5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfigure implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor5 loginInterceptor;
    @Override
    //注入拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/api/example5/**")  //拦截路径
                .excludePathPatterns("/api/example5/login");  //拦截排除路径
    }
}
