package com.dlj.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @Description: 音乐盒控制器
* @Author: dljdlj
* @Date: 2021/4/1
* @Url: dljdlj.top
*/
@Controller
public class MusicController {

    @RequestMapping("/music")
    public String resPage(Model model){
        model.addAttribute("page","music");
        return "music";
    }
}
