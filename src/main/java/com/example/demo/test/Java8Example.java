package com.example.demo.test;

import com.example.demo.aop.FieldTypeEnum;
import com.example.demo.aop.TableSchema;
import com.example.demo.aop.User;
import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Example {

    private final static Gson gson = new Gson();
    public static void main(String[] args) {

        List<String> items = Arrays.asList(
                "apple", "apple1",
                "orange", "orange1", "orange2",
                "blueberry",
                "peach", "peach", "peach", "peach"
        );
        //List<User> list = new ArrayList<>();
        User u= new User("username","userage");
        String str = gson.toJson(u);
        User str1= gson.fromJson(u.content,User.class);


        //Map<Integer, List<User>> nameFieldInfoMap = list.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(str1.getName());

    }


}
