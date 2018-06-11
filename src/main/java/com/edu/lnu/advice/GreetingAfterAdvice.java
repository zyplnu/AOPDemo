package com.edu.lnu.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置增强
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    //在目标类方法调用后执行
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Please enjoy yourself");
    }
}
