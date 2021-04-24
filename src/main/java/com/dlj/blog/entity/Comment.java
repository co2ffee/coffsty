package com.dlj.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
* @Description: 评论实体类
* @Author: dljdlj
* @Date: 2021/4/1
* @Url: dljdlj.top
* @Remark: 
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
    private Long id;
    private String content;
    private Date createTime;
    private Long parentCommentId;
    private String parentNickname;
    private Long blogId;
    private Long userId;

    //user
    private String nickname;
    private String avatar;

    //回复评论
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;

//    private DetailedBlog blog;
}
