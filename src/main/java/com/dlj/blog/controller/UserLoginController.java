package com.dlj.blog.controller;

import com.dlj.blog.entity.User;
import com.dlj.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
/** 
* @Description: 登录页控制器
* @Author: dljdlj
* @Date: 2021/4/9
* @Url: dljdlj.top
* @Remark: 
*/
@Controller
@Slf4j
public class UserLoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/userLogin", "/userLogin/login"}, method = RequestMethod.GET)
    public String resLogin() {
        return "userlogin";
    }

    @RequestMapping(value = {"/userLogin", "/userLogin/login"}, method = RequestMethod.POST)
    public String userLogin(@RequestParam() String username,
                            @RequestParam() String password,
                            HttpSession session,
                            Model model) {
        User user = userService.selectUser(username, password);
        log.info("user:{}", user);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/index";
        } else {
            model.addAttribute("loginerr", "用户名或密码错误");
            return "userlogin";
        }
    }

    @RequestMapping(value = "/userLogin/reg",method = RequestMethod.GET)
    public String resReg() {
        return "userreg";
    }

    @RequestMapping(value = "/userLogin/reg",method = RequestMethod.POST)
    public String userReg(User user,Model model) {
        userService.regUser(user);
        model.addAttribute("regerr","err");
        return "redirect:/userLogin";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("user",null);
        return "redirect:/index";
    }
}
