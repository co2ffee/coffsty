package com.dlj.blog.dao;

import com.dlj.blog.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageDao {
    List<Message> searchAllMessage(Long id);

    int saveMessage(Message message);
}
