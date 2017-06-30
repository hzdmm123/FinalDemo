package com.finaldemo.dao;

import com.finaldemo.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    User selectUser(long id);
    int checkLogin(@Param("username") String userName, @Param("password") String password);
    List<User> showUser();

}
