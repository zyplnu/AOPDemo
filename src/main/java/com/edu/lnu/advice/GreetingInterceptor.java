package com.edu.lnu.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕增强
 * Spring使用AOP联盟定义的MethodInterceptor作为环绕增强的接口。
 * 该接口拥有唯一的接口方法invoke(),
 * MethodInvocation不但封装了目标方法及入参数组，还封装了目标方法所在的实例对象，
 * 通过MethodInvocation的getArguments()方法可以获取目标方法的入参数组，
 * 通过proceed()方法反射调用目标实例相应的方法。
 */
public class GreetingInterceptor implements MethodInterceptor{
    /**
     *
     * @param methodInvocation
     * @return
     * @throws Throwable
     */
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];
        System.out.println("How are you! Mr." + clientName + ".");

        Object obj = methodInvocation.proceed();

        System.out.println("Please enjoy yourself");

        return obj;
    }
}
