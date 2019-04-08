package com.example.springmvc_learn.requirementAdded.control;

import com.example.springmvc_learn.requirementAdded.entity.User2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class User2Controller {
    private static List<User2> users=create();
         //asList()产生的容器类型不可变！！！
            /*= Arrays.<User2>asList(
            new User2(1, "GT", "1234", "101"),
            new User2(2, "Sun", "5678", "101")
    );*/
    private static List<User2> create(){
        List<User2> user2s=new ArrayList<>();
        User2 user1=new User2(1, "GT", "1234", "101");
        User2 user2=new User2(2, "Sun", "5678", "101");
        user2s.add(user1);
        user2s.add(user2);
        return user2s;
    }

    @GetMapping("/users")
    public Map getUsers() {
        return Map.of("users", users);
    }

    @PostMapping("/users")
    public Map postUser(@RequestBody User2 user2) {
        users.add(user2);
        return Map.of("users", user2);
    }

    @GetMapping("/users/{uid}")
    public Map getUser(@PathVariable int uid) {
        log.debug("{}", uid);
        User2 user2 = users.stream().filter(u ->
                u.getId() == uid).findFirst().orElse(null);
        return Optional.ofNullable(user2).map(u -> Map.of("user", u)).orElse(Map.of());
    }
}
