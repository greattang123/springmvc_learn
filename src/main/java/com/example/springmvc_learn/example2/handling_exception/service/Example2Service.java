package com.example.springmvc_learn.example2.handling_exception.service;

import com.example.springmvc_learn.example2.handling_exception.exception.MyException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class Example2Service {
    public void addFile(){
        try {
            Files.readString(Path.of("A:/a/a"));
        }catch (IOException e){
            throw new MyException("文件处理错误！"+e.getMessage() );
        }
    }
}
