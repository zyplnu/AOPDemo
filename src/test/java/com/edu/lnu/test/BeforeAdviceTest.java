package com.edu.lnu.test;

import com.edu.lnu.advice.GreetingBeforeAdvice;
import com.edu.lnu.aop.NativeWaiter;
import com.edu.lnu.aop.Waiter;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

public class BeforeAdviceTest {

    @Test
    public void before(){
        Waiter target = new NativeWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setInterfaces(target.getClass().getInterfaces());
        proxyFactory.setOptimize(true);
        proxyFactory.setTarget(target);

        proxyFactory.addAdvice(advice);
        System.out.println(proxyFactory.getClass());
        Waiter proxy = (Waiter)proxyFactory.getProxy();
        proxy.greetTo("John");
        proxy.saveTo("Tom");

    }

}
