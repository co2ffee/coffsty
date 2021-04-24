package com.dlj.blog.controller;

import com.dlj.blog.entity.Flag;
import com.dlj.blog.pojo.BlogPageInfo;
import com.dlj.blog.service.TypeService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
* @Description: 分类页控制器
* @Author: dljdlj
* @Date: 2021/3/31
* @Url: dljdlj.top
*/
@Controller
@Slf4j
public class TypesController {

    @Autowired
    TypeService typeService;

    @RequestMapping({"/types","/types/{flagId}"})
    public String resPage(Model model,@PathVariable(required = false,value = "flagId") String flagId){
        model.addAttribute("page","types");

        log.info("{}",flagId);
        List<BlogPageInfo> typeBlogPageInfo = typeService.getTypeBlogPageInfo(flagId);
        PageInfo<BlogPageInfo> pageInfo = new PageInfo<>(typeBlogPageInfo);
        List<Flag> allFlag = typeService.getAllFlag();
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("flags",allFlag);
        return "types";
    }
}
