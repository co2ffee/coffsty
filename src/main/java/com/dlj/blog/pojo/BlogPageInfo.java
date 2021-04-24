package com.dlj.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
/** 
* @Description: 博客简表
* @Author: dljdlj
* @Date: 2021/4/1
* @Url: dljdlj.top
* @Remark: 
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogPageInfo {
    //Blog
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private long flagId;
    private String description;

    //Flag

    private String flagName;

    //User
    private String nickname;
    private String avatar;
}
