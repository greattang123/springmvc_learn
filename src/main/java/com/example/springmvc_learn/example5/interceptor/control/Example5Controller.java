package com.example.springmvc_learn.example5.interceptor.control;

import com.example.springmvc_learn.example5.interceptor.component.EncryptorComponent5;
import com.example.springmvc_learn.example5.interceptor.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example5")
public class Example5Controller {
    @Autowired
    private EncryptorComponent5 ec;
    @PostMapping("/login")
    public void login(@RequestBody Map<String, String> user, HttpServletResponse response) {
        if ("GT".equals(user.get("name"))) {
            // 模拟登录
            //将用户信息封装到map
            Map<String, Object> map = new HashMap<>();
            map.put("uid", 1);
            map.put("aid", 1);
            // 调用encrypt()将map对象加密生成token
            String token =ec.encrypt(map);
            log.debug(token);
            /* 在header创建自定义权限，且将加密的token
            以自定义属性置于其中*/
            response.setHeader("Authorization", token);
        } else {
            // 登录失败，抛出权自定义异常
            throw new UnauthorizedException();
        }
    }
    @GetMapping("/index")
    public Map getIndex() {
        return Map.of("index", "root");
    }
}
