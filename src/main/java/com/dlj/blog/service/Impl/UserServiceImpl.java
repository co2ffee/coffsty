package com.dlj.blog.service.Impl;

import com.dlj.blog.dao.UserDao;
import com.dlj.blog.entity.User;
import com.dlj.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User selectUser(String username, String password) {
        return userDao.selectUser(username,password);
    }

    //注册用户
    @Override
    public int regUser(User user) {
        //当前日期
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String nowDate=date.format(formatter);
        user.setType(0);
        user.setCreateTime(Date.valueOf(nowDate));
        log.info("{}",user);
        return userDao.regUser(user);
    }

    //判断用户是否存在，不存在自动注册
    @Override
    public User autoReg(String username, String nickname, String password) {
        User user = selectUser(username, password);
        log.info("user:{}", user);
        if (user == null) {
            user = new User();
            user.setUsername(username);
            user.setNickname(nickname);
            user.setPassword(password);
            regUser(user);
            user = selectUser(username, password);
        }
        return user;
    }
}
