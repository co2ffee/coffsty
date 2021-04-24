package com.dlj.blog.service;

import com.dlj.blog.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> searchAllMessage();
    int saveMessage(Message message);
}
