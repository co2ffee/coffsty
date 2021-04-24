package com.dlj.blog.service;

import com.dlj.blog.entity.User;

public interface UserService {
    User selectUser(String username,String password);
    int regUser(User user);
    User autoReg(String username,String nickname,String password);
}
