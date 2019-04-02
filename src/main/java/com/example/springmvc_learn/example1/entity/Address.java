package com.example.springmvc_learn.example1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Address {
    private int id;
    private String detail;
    private String comment;
    private User user;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime insertTime;

    public Address(int id, String detail) {
        this.id = id;
        this.detail = detail;
    }
}
