package com.dlj.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @Description: 博客管理
* @Author: dljdlj
* @Date: 2021/4/10
* @Url: dljdlj.top
* @Remark:
*/
@Controller
public class AdminBlogController {
    @RequestMapping("/admin/blogs")
    public String adminBlog(){
        return "admin/blogs";
    }
}
