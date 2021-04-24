package com.dlj.blog.conf;

import com.dlj.blog.utils.GetPathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
* @Description: 拦截页配置
* @Author: dljdlj
* @Date: 2021/4/10
* @Url: dljdlj.top
* @Remark:
*/
@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {
    @Autowired
    GetPathUtils getPathUtils;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/avatar/**").addResourceLocations("file:" + getPathUtils.getPathBySlash());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**");
    }
}
