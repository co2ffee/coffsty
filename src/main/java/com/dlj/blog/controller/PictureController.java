package com.dlj.blog.controller;

import com.dlj.blog.entity.User;
import com.dlj.blog.service.PictureService;
import com.dlj.blog.utils.GetPathUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Description: 照片墙控制器
 * @Author: dljdlj
 * @Date: 2021/4/1
 * @Url: dljdlj.top
 */
@Controller
@Slf4j
public class PictureController {

    @Autowired
    PictureService pictureService;
    @Autowired
    GetPathUtils getPathUtils;

    @RequestMapping("/picture")
    public String resPage(Model model) {
        model.addAttribute("page", "picture");
        return "picture";
    }

    //头像上传
    @RequestMapping("/upload")
    public String uploadAvatar(User user,
                               MultipartFile headerImg) {
        saveAvatar(user, headerImg);
        return "redirect:/index";
    }

    //头像保存服务器
    void saveAvatar(User user,
                    MultipartFile headerImg) {
        String path = getPathUtils.getPath();
        log.info("{}", path);
        log.info("用户信息:{}", user);
        log.info("图片上传信息:{}", headerImg.getOriginalFilename());
        if (!headerImg.isEmpty()) {
            //保存到文件服务器，OSS服务器
            String avatarId = "avatar" + String.valueOf(user.getId()) + ".jpg";
            path = path + avatarId;
            try {
                headerImg.transferTo(new File(path));
                pictureService.saveAvatar(avatarId, user.getId());
                log.info("成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
