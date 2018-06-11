package com.edu.lnu.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 采用Cglib方式进行代理
 * CGLib采用底层的字节码技术，可以为一个类创建子类，在子类中采用方法拦截的技术拦截
 * 所有父类方法的调用并顺势织入横切逻辑
 */
public class CglibProxy implements MethodInterceptor{

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    //拦截父类所有方法的调用
    public Object intercept(Object obj , Method method , Object[] args , MethodProxy proxy) throws Throwable{
        PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());
        //通过代理类调用父类中的方法
        Object result = proxy.invokeSuper(obj , args);
        PerformanceMonitor.end();
        return result;
    }

}
