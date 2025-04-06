package com.kether.springbootlogindemo.dao.Impl;


import com.kether.springbootlogindemo.dao.UserDao;
import com.kether.springbootlogindemo.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    private static Map<String, User> users = new HashMap<>();
    //模擬資料庫
    static {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        users.put("admin", user);
    }

    public User findByUsername(String username) {
        return users.get(username);
    }
}