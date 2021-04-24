package com.dlj.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @Description: 标签管理
* @Author: dljdlj
* @Date: 2021/4/10
* @Url: dljdlj.top
* @Remark:
*/
@Controller
public class AdminTypeController {
    @RequestMapping("/admin/types")
    public String adminType(){
        return "admin/types";
    }
}
