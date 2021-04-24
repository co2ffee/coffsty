package com.dlj.blog.service.Impl;

import com.dlj.blog.dao.MessageDao;
import com.dlj.blog.entity.Message;
import com.dlj.blog.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;

    //存放迭代找出的所有子代的集合
    private List<Message> tempReplys = new ArrayList<>();

    @Override
    public List<Message> searchAllMessage() {
        //查询出父节点
        List<Message> messages = messageDao.searchAllMessage(Long.parseLong("-1"));
        for(Message message : messages){
            Long id = message.getId();
            String parentNickname = message.getNickname();
            List<Message> childMessages = messageDao.searchAllMessage(id);
            //查询出子留言
            searchChildMessage(childMessages, parentNickname);
            message.setReplyMessages(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return messages;
    }

    private void searchChildMessage(List<Message> childMessages, String parentNickname) {
        //判断是否有一级子回复
        if(childMessages.size() > 0){
            //循环找出子留言的id
            for(Message childMessage : childMessages){
                String childParentNickname = childMessage.getNickname();
                childMessage.setParentNickname(parentNickname);
                tempReplys.add(childMessage);
                Long childId = childMessage.getId();
                //根据id查询二级以及所有子集回复
                recursively(childId, childParentNickname);
            }
        }
    }

    private void recursively(Long childId, String childParentNickname) {
        //根据子一级留言的id找到子二级留言
        List<Message> replayMessages = messageDao.searchAllMessage(childId);

        if(replayMessages.size() > 0){
            for(Message replayMessage : replayMessages){
                String parentNickname = replayMessage.getNickname();
                replayMessage.setParentNickname(childParentNickname);
                Long replayId = replayMessage.getId();
                tempReplys.add(replayMessage);
                //循环迭代找出子集回复
                recursively(replayId,parentNickname);
            }
        }
    }

    @Override
    public int saveMessage(Message message) {
        //当前日期
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowDate=dateTime.format(formatter);

        log.info("{}",nowDate);
        message.setCreateTime(Timestamp.valueOf(nowDate));
        return messageDao.saveMessage(message);
    }
}
