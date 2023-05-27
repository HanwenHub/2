package com.example.demo.aop;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException{
    private String msg;
    public BusinessException(String msg,int code){
        super(msg);
    }
}
