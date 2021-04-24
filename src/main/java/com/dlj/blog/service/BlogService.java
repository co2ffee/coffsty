package com.dlj.blog.service;

import com.dlj.blog.pojo.BlogPageInfo;
import com.dlj.blog.pojo.BlogShow;

import java.util.List;


public interface BlogService {
    List<BlogPageInfo> getAllBlogPageInfo();
    BlogShow getBlogById(long id);
    List<BlogPageInfo> searchBlog(String keyString);
    Integer getBlogTotal();
    Integer getBlogViewTotal();
    Integer getBlogCommentTotal();
    Integer getBlogMessageTotal();
}
