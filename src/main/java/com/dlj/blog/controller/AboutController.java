package com.dlj.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @Description: 关于页控制器
* @Author: dljdlj
* @Date: 2021/4/1
* @Url: dljdlj.top
*/
@Controller
public class AboutController {

    @RequestMapping("/about")
    public String typesRes(Model model){
        model.addAttribute("page","about");
        return "about";
    }
}
