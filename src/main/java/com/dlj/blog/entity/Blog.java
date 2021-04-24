package com.dlj.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/** 
* @Description: 博客实体类
* @Author: dljdlj
* @Date: 2021/4/1
* @Url: dljdlj.top
* @Remark: 
*/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    private Long id;
    private String title;
    private String content;
    private Integer views;
    private Integer commentCount;
    private Date createTime;
    private Date updateTime;
    private Long flagId;
    private Long userId;
    private String description;
    private String firstPicture;

    private Flag flag;
    private User user;
    private List<Comment> comments = new ArrayList<>();

}
