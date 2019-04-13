package com.example.springmvc_learn.example2.handling_exception.control;

import com.example.springmvc_learn.example2.handling_exception.service.Example2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/example2")
public class Example2Controller {
    @Autowired
    private Example2Service es;
    @GetMapping("/exception")
    public void getException(){
        es.addFile();
    }
}
