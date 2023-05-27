package com.example.demo.aop;

public enum Operation {
    NOMU("不模拟"),
    MODETHS("模拟");
    private final String  value;
    Operation(String value){
      this.value = value;
    }
    public String getValue(){
        return value;
    }
}
