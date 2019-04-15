package com.example.springmvc_learn.example3.bean_validation.control;

import com.example.springmvc_learn.example3.bean_validation.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Map;

@RestController
@RequestMapping("/api/example3")
@Validated
public class Example3Controller {
    @PostMapping("/users")
    public Map postUser(@Valid @RequestBody User user){
        return Map.of();
    }
    @GetMapping("/users/{uid}/file")
    public void getTypeMismatchException(@PathVariable int uid){

    }
    @GetMapping("/users/{userName}")
    public void getTypeMismatchException(@PathVariable String userName){

    }
    @GetMapping("/users/{owner}")
    public void getViolationException(
            @Size(min=2,max=6,message = "用户信息错误")
            @PathVariable String owner){

    }
}
