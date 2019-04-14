package com.example.springmvc_learn.example4.password_encoder.control;

import com.example.springmvc_learn.example4.password_encoder.entity.User4;
import com.example.springmvc_learn.example4.password_encoder.service.UserService4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/example4")
public class Example4Controller {
    @Autowired
    private UserService4 us;
    @Autowired
    private PasswordEncoder pe;
    @PostMapping("/register")
    //注册
    public void register(@RequestBody User4 user) {
        String password = pe.encode(user.getPassword());
        log.debug(password);
        user.setPassword(password);
        us.addUser(user);
    }
    //登陆
    @PostMapping("/login")
    public void login(@RequestBody Map<String, String> user) {
        // 查询用户是否存在
        Optional.ofNullable(us.getUser(user.get("name")))
                .ifPresentOrElse(u -> {
                    // 若存在，密码比对
                    if (pe.matches(user.get("password"), u.getPassword())) {
                        log.debug("用户存在且密码正确");
                    } else {
                        log.debug("用户存在但密码错误");
                    }
                },() -> log.debug("用户不存在"));
    }
}
