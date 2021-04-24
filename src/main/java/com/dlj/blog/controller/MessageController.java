package com.dlj.blog.controller;

import com.dlj.blog.entity.Message;
import com.dlj.blog.entity.User;
import com.dlj.blog.service.MessageService;
import com.dlj.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: 消息控制器
 * @Author: dljdlj
 * @Date: 2021/4/1
 * @Url: dljdlj.top
 */
@Controller
@Slf4j
public class MessageController {

    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;


    @RequestMapping("/message")
    public String resPage(Model model) {
        model.addAttribute("page", "message");
        return "message";
    }

    //    查询留言
    @GetMapping("/messagecomment")
    public String messages(Model model) {
        List<Message> messages = messageService.searchAllMessage();
        model.addAttribute("messages", messages);
        log.info("{}", messages.toArray());
        return "message::messageList";
    }

    //    新增留言
    @PostMapping("/message")
    public String post(String username,
                       @RequestParam(defaultValue = "未设置昵称") String nickname,
                       String password,
                       String content,
                       @RequestParam("parentMessage.id") String parentMessageId,
                       Model model,
                       HttpSession session) {
        log.info("{}", parentMessageId);
        //判断用户是否存在，不存在自动注册
        User user = userService.autoReg(username, nickname, password);
        session.setAttribute("user", user);
        //添加留言
        Message message = new Message();
        message.setUserId(user.getId());
        message.setContent(content);
        if (parentMessageId != null) {
            message.setParentMessageId(Long.parseLong(parentMessageId));
        } else {
            message.setParentMessageId(Long.parseLong("-1"));
        }
        messageService.saveMessage(message);
        List<Message> messages = messageService.searchAllMessage();
        model.addAttribute("messages", messages);
        return "message::messageList";
    }
}
