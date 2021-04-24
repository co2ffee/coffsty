package com.dlj.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
/** 
* @Description: 博客详情页
* @Author: dljdlj
* @Date: 2021/4/2
* @Url: dljdlj.top
* @Remark: 
*/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BlogShow{
    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private Date updateTime;
    private long flagId;
    private Integer views;
    private Integer commentCount;
    //flag

    private String flagName;
    //user
    private String nickname;
    private String avatar;
}
