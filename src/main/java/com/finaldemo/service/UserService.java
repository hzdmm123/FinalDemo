package com.finaldemo.service;

import com.finaldemo.model.User;

import java.util.List;

public interface UserService {

    public User selectUser(long userId);
    public int CheckLogin(String userName,String password);
    public List<User> showUser();

}