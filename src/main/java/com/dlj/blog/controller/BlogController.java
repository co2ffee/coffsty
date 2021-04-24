package com.dlj.blog.controller;

import com.dlj.blog.entity.Comment;
import com.dlj.blog.entity.User;
import com.dlj.blog.pojo.BlogShow;
import com.dlj.blog.service.BlogService;
import com.dlj.blog.service.CommentService;
import com.dlj.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: 博客控制器
 * @Author: dljdlj
 * @Date: 2021/4/1
 * @Url: dljdlj.top
 * @Remark: 非单独页面
 */
@Controller
@Slf4j
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    @RequestMapping("/blog/{id}")
    public String resBlog(Model model, @PathVariable("id") String id) {

        BlogShow blog = blogService.getBlogById(Long.parseLong(id));
        model.addAttribute("blog", blog);
        return "blog";
    }

    //查询评论
    @GetMapping("/blog/comments/{blogId}")
    public String messages(Model model, @PathVariable Long blogId) {
        log.info("blogid:{}", blogId);
        List<Comment> comments = commentService.searchAllComment(Long.valueOf(blogId));
        model.addAttribute("comments", comments);
        log.info("comments:{}", comments);
        return "blog::commentList";
    }


    //新增留言
    @PostMapping("/blog/{id}")
    public String post(String username,
                       @RequestParam(defaultValue = "未设置昵称") String nickname,
                       String password,
                       String content,
                       @RequestParam("parentComment.id") String parentCommentId,
                       @PathVariable("id") String blogId,
                       Model model,
                       HttpSession session) {
        log.info("parentCommentId:{}", parentCommentId);
        log.info("blogId:{}", blogId);
        //判断用户是否存在，不存在自动注册
        User user = userService.autoReg(username, nickname, password);
        session.setAttribute("user", user);
        //添加评论
        Comment comment = new Comment();
        comment.setUserId(user.getId());
        comment.setContent(content);
        comment.setBlogId(Long.valueOf(blogId));
        if (parentCommentId != null) {
            comment.setParentCommentId(Long.parseLong(parentCommentId));
        } else {
            comment.setParentCommentId(Long.parseLong("-1"));
        }
        commentService.saveComment(comment);
        List<Comment> comments = commentService.searchAllComment(Long.valueOf(blogId));
        model.addAttribute("comments", comments);
        return "blog::commentList";
    }
}
