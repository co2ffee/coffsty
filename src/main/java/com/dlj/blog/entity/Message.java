package com.dlj.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
* @Description: 留言实体类
* @Author: dljdlj
* @Date: 2021/4/4
* @Url: dljdlj.top
* @Remark: 
*/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Long id;
    private String content;
    private Date createTime;
    private Long parentMessageId;
    private Long userId;

    //user
    private String nickname;
    private String avatar;

    //回复留言
    private List<Message> replyMessages = new ArrayList<>();
    private Message parentMessage;
    private String parentNickname;
}
