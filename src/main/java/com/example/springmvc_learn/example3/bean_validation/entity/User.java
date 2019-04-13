package com.example.springmvc_learn.example3.bean_validation.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private  int id;
    @Size(min=2,max=6,
    message = "您输入的值为${validatedValue},用户名长度必须大于{min}，小于{max}")
    private  String name;
    @Min(value = 18,
    message = "您输入的值为${validatedValue},年龄不能小于{min}")
    @Max(value = 60,
    message = "您输入的值为${validatedValue},年龄不能小于{max}")
    private  int age;
    @Email(message = "Email 不合法")
    private  String email;
}
