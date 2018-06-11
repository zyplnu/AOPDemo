package com.edu.lnu.test;

import com.edu.lnu.aop.CglibProxy;
import com.edu.lnu.aop.PerformanceHandler;
import com.edu.lnu.service.ForumService;
import com.edu.lnu.service.UserService;
import com.edu.lnu.service.serviceImpl.ForumServiceImpl;
import com.edu.lnu.service.serviceImpl.UserServiceImpl;
import org.testng.annotations.Test;

import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;

public class TestForumService {

    @Test
    public void testProxy(){
        ForumService service = new ForumServiceImpl();
        service.removeForum(10);
        service.removeTopic(1012);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
    }

    @Test
    public void proxy(){
        ForumService target = new ForumServiceImpl();

        PerformanceHandler handler = new PerformanceHandler(target);

        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                                    target.getClass().getInterfaces(),handler);

        proxy.removeForum(10);

        proxy.removeTopic(1012);
    }

    @Test
    public void testUserInterface(){
        UserService target = new UserServiceImpl();

        PerformanceHandler handler = new PerformanceHandler(target);

        UserService proxy = (UserService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);
        System.out.println("*************");
        System.out.println(proxy);
        System.out.println("*************");
        proxy.login();
        proxy.logout();
    }

    @Test
    public void cglibProxy(){
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1024);
    }
}
