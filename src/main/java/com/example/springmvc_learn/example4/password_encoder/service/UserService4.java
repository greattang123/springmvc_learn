package com.example.springmvc_learn.example4.password_encoder.service;

import com.example.springmvc_learn.example4.password_encoder.entity.User4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
public class UserService4 {
    private Map<String, User4> map = new HashMap<>();
    //基于用户名获取用户
    public User4 getUser(String name) {
        return map.get(name);
    }
    public void addUser(User4 user) {
        map.put(user.getName(), user);
    }
}
