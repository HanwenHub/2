package com.example.demo.aop;

import lombok.Data;

@Data
public class User {
    private String name;
    private String age;
    private String userPassword;
    private String userAccount;
    private String checkPassword;
    private int classname;
    public static final String str = "[小米,华为,jd]";
    public static final String content = "{name:username,age:userage}";

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
    public User(){}
}
