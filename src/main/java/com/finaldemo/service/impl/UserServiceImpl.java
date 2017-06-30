package com.finaldemo.service.impl;

import com.finaldemo.dao.UserDao;
import com.finaldemo.model.User;
import com.finaldemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    @Override
    public int CheckLogin(String userName, String password) {
        return userDao.checkLogin(userName,password);
    }

    @Override
    public List<User> showUser() {
        return userDao.showUser();
    }

}