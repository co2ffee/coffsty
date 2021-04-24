package com.dlj.blog.service.Impl;

import com.dlj.blog.dao.BlogDao;
import com.dlj.blog.pojo.BlogPageInfo;
import com.dlj.blog.pojo.BlogShow;
import com.dlj.blog.service.BlogService;
import com.dlj.blog.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
* @Description: 博客服务层
* @Author: dljdlj
* @Date: 2021/4/3
* @Url: dljdlj.top
* @Remark: 
*/
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogDao blogDao;

    //返回所有博客简介
    @Override
    public List<BlogPageInfo> getAllBlogPageInfo() {
        return blogDao.getAllBlogPageInfo();
    }

    //博客查询与博客内容处理
    @Override
    public BlogShow getBlogById(long id) {
        BlogShow blogShow = blogDao.getBlogById(id);
        String content = blogShow.getContent();
        blogShow.setContent(MarkdownUtils.markdownToHtmlExtensions(content));

        blogDao.updateViews(id);
        return blogShow;
    }

    @Override
    public List<BlogPageInfo> searchBlog(String keyString) {
        keyString="%"+keyString+"%";
        return blogDao.searchBlog(keyString);
    }

    @Override
    public Integer getBlogTotal() {
        return blogDao.getBlogTotal();
    }

    @Override
    public Integer getBlogViewTotal() {
        return blogDao.getBlogViewTotal();
    }

    @Override
    public Integer getBlogCommentTotal() {
        return blogDao.getBlogCommentTotal();
    }

    @Override
    public Integer getBlogMessageTotal() {
        return blogDao.getBlogMessageTotal();
    }
}
