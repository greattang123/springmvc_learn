package com.example.springmvc_learn.example1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
