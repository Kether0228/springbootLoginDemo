package com.kether.springbootlogindemo.service.Impl;

import com.kether.springbootlogindemo.dao.UserDao;
import com.kether.springbootlogindemo.model.User;
import com.kether.springbootlogindemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User validateUser(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
