package com.example.demo.controller;

import com.example.demo.aop.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Permission(value="/permission/getUser")
    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(User user){
        if(user.getName()!=null){
            throw new BusinessException("请求参数不对",203);
        }
        return "hello";
    }

    @PostMapping("/")
    public String getCreatSql(@RequestBody GenerateBySqlRequest generateBySqlRequest){
        String[] list ={"A","p"};
        List<String> lists = Arrays.stream(list)
                .filter(StringUtils::isNoneBlank)
                .collect(Collectors.toList());
        if(generateBySqlRequest.equals(null)){
            return new RuntimeException("系统惨书异常").toString();
        }
        return "";
    }
}
