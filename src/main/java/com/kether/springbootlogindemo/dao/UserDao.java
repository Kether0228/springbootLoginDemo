package com.kether.springbootlogindemo.dao;

import com.kether.springbootlogindemo.model.User;

public interface UserDao {
    User findByUsername(String username);
}
