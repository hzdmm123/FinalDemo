package com.finaldemo.dao;

import com.finaldemo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao dao;

    @Test
    public void testSelectUser() throws Exception {
        long id = 1;
        User user = dao.selectUser(id);
        System.out.println(user.getUsername());
    }
    @Test
    public void testCheckLogin() throws Exception{
        String userName= "xxxxx";
        String password= "xxxxx";
        int c = dao.checkLogin(userName,password);
        System.out.println("成功查到"+c+"个人");
    }

    @Test
    public void testShowUser() throws Exception{
        List<User> users = dao.showUser();
        System.out.println(users.size());
    }

}