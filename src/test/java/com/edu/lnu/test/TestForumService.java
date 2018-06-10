package com.edu.lnu.test;

import com.edu.lnu.service.ForumService;
import com.edu.lnu.service.serviceImpl.ForumServiceImpl;
import org.testng.annotations.Test;

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
}
