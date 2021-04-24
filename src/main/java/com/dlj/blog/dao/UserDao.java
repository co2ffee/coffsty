package com.dlj.blog.dao;

import com.dlj.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User selectUser(String username, String password);
    int regUser(User user);
}
