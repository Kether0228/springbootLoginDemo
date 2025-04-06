package com.kether.springbootlogindemo.service;

import com.kether.springbootlogindemo.model.User;

public interface UserService {
    User validateUser(String username, String password);
}
