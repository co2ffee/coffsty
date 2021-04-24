package com.dlj.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @Description: 管理首页
* @Author: dljdlj
* @Date: 2021/4/10
* @Url: dljdlj.top
* @Remark:
*/
@Controller
public class AdminIndexController {

    @RequestMapping({"/admin","/admin/index"})
    public String adminIndex(){
        return "admin/index";
    }
}
