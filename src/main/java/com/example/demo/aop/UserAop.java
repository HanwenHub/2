package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


@Aspect
@Component
public class UserAop {

    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    public void record(){
        System.out.println("hahahha");
    }
    @Around("record()")
    public Object doInterceptor(ProceedingJoinPoint point) throws Throwable{
        //获得方法签名
        MethodSignature methodSignature=(MethodSignature) point.getSignature();
        //获得方法
        Method aimMethod= methodSignature.getMethod();
        String permission=aimMethod.getAnnotation(Permission.class).value();
        //权限集合
        List<String> str = new ArrayList<>();
        str.add("/permission/getUser");
        Object result = null;
        if(str.contains(permission)){
            //执行原方法的步骤
             result = point.proceed();
        }else {
            return "没有权限";
        }
        return result;
    }
    @Before("record()")
    public void getUser(){
        System.out.println(123456);
    }

}
