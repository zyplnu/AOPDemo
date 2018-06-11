package com.edu.lnu.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 采用JDK动态代理技术
 * JDK动态代理技术主要涉及java.lang.reflect包中的两个类：Proxy和InvocationHandler
 * 其中InvocationHandler是一个接口，可以通过实现该接口定义横切逻辑，并通过反射机制调用目标类的
 * 代码，动态地将横切逻辑和业务逻辑编织在一起。
 */
public class PerformanceHandler implements InvocationHandler {

    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        //查看args数组是什么东西
        /*System.out.println("------------");
        for(Object obj : args){
            System.out.println(obj);
        }
        System.out.println("------------");*/
        System.out.println(method.getName());
        Object obj = method.invoke(target);
        PerformanceMonitor.end();
        return obj;
    }
}
