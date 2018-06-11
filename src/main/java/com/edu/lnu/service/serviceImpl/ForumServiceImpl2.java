package com.edu.lnu.service.serviceImpl;

import com.edu.lnu.pojo.Forum;

import java.sql.SQLException;

/**
 * 异常抛出增强业务类
 */
public class ForumServiceImpl2 {

    public void removeForum(int forumId){
        System.out.println("模拟删除forum记录：" + forumId);
    }

    public void updateForum(Forum forum){

    }

}
