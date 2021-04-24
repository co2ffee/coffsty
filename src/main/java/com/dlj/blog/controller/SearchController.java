package com.dlj.blog.controller;

import com.dlj.blog.pojo.BlogPageInfo;
import com.dlj.blog.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
* @Description: 搜索控制器
* @Author: dljdlj
* @Date: 2021/4/1
* @Url: dljdlj.top
* @Remark: 非单独页面
*/
@Controller
public class SearchController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/search")
    public String resPage(Model model,
                          @RequestParam String keyString){
        List<BlogPageInfo> blogPageInfos = blogService.searchBlog(keyString);
        PageInfo<BlogPageInfo> pageInfo = new PageInfo<>(blogPageInfos);
        model.addAttribute("pageInfo",pageInfo);
        return "search";
    }
}
