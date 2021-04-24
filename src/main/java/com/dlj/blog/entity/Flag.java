package com.dlj.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
/** 
* @Description: 标签实体类
* @Author: dljdlj
* @Date: 2021/4/1
* @Url: dljdlj.top
* @Remark: 
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Flag {
    private Long id;
    private String flagName;

    private List<Blog> blogs = new ArrayList<>();
}
