package com.dlj.blog.conf;

import com.dlj.blog.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 登陆拦截逻辑配置
 * @Author: dljdlj
 * @Date: 2021/4/10
 * @Url: dljdlj.top
 * @Remark:
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            log.info("未登陆用户被拦截了");
            response.sendRedirect("/index");
            return false;
        } else if (user.getType() != 1) {
            log.info("用户Id：{} 被拦截了", user.getId());
            response.sendRedirect("/index");
            return false;
        }
        return true;
    }
}