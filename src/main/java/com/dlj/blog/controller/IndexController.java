package com.dlj.blog.controller;

import com.dlj.blog.pojo.BlogPageInfo;
import com.dlj.blog.service.BlogService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/** 
* @Description: 主页控制器
* @Author: dljdlj
* @Date: 2021/3/31 
* @Url: dljdlj.top
*/
@Controller
@Slf4j
public class IndexController {

    @Autowired
    BlogService blogService;

    @RequestMapping({"/","/index"})
    public String resPage(Model model){
        model.addAttribute("page","index");
        List<BlogPageInfo> allBlogPageInfo = blogService.getAllBlogPageInfo();
        PageInfo<BlogPageInfo> pageInfo = new PageInfo<>(allBlogPageInfo);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }

    //    博客底部信息
    @RequestMapping("/footer/blogmessage")
    public String blogMessage(Model model){
        int blogTotal = blogService.getBlogTotal();
        int blogViewTotal = blogService.getBlogViewTotal();
        int blogCommentTotal = blogService.getBlogCommentTotal();
        int blogMessageTotal = blogService.getBlogMessageTotal();
        log.info("blogTotal:{}",blogTotal);
        log.info("blogViewTotal:{}",blogViewTotal);
        model.addAttribute("blogTotal",blogTotal);
        model.addAttribute("blogViewTotal",blogViewTotal);
        model.addAttribute("blogCommentTotal",blogCommentTotal);
        model.addAttribute("blogMessageTotal",blogMessageTotal);
        return "common :: blogMessage";
    }
}
