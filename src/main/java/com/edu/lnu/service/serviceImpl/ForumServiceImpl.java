package com.edu.lnu.service.serviceImpl;

import com.edu.lnu.aop.PerformanceMonitor;
import com.edu.lnu.pojo.Forum;
import com.edu.lnu.service.ForumService;

public class ForumServiceImpl implements ForumService {


    public void removeTopic(int topicId) {
        //开始对该方法进行性能监控
//        PerformanceMonitor.begin("cn.edu.lnu.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除Topic记录：" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //结束对该方法进行性能监视
//        PerformanceMonitor.end();
    }

    public void removeForum(int forumId) {
        //开始对该方法进行性能监控
//        PerformanceMonitor.begin("cn.edu.lnu.ForumServiceImpl.removeForum");
        System.out.println("模拟删除Topic记录：" + forumId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //结束对该方法进行性能监视
//        PerformanceMonitor.end();
    }
}
