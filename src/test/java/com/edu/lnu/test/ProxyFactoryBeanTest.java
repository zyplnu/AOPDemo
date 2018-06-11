package com.edu.lnu.test;

import com.edu.lnu.advice.Monitorable;
import com.edu.lnu.aop.Waiter;
import com.edu.lnu.pojo.Forum;
import com.edu.lnu.service.serviceImpl.ForumServiceImpl2;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class ProxyFactoryBeanTest {

    @Test
    public void testProxyFactoryBean() throws SQLException {
        String configPath = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        /*Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");*/
        ForumServiceImpl2 serviceImpl2 = (ForumServiceImpl2) ctx.getBean("forumService");
        //serviceImpl2.removeForum(10);

        serviceImpl2.removeForum(10);

        Monitorable monitorable = (Monitorable) serviceImpl2;
        monitorable.setMonitorActive(true);

        serviceImpl2.removeForum(10);

    }

}
