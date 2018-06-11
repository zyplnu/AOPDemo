package com.edu.lnu.test;

import com.edu.lnu.advisor.Seller;
import com.edu.lnu.advisor.Waiter;
import org.springframework.aop.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * 切面测试类
 */
public class AdvisorTest {

    @Test
    public void testAdvisor(){
        String configPath = "repbeans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Waiter waiter = (Waiter) ctx.getBean("waiter");
//        Seller seller = (Seller) ctx.getBean("seller");

        waiter.greetTo("John");
        waiter.serveTo("John");
//        seller.greetTo("John");

    }

}
