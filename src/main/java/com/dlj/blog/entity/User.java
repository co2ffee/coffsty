package com.dlj.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
/** 
* @Description: 用户实体类
* @Author: dljdlj
* @Date: 2021/4/1
* @Url: dljdlj.top
* @Remark: 
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String avatar;
    private Integer type;
    private Date createTime;
    private Date updateTime;
}
