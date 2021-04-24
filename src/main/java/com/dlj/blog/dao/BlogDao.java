package com.dlj.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dlj.blog.entity.Blog;
import com.dlj.blog.pojo.BlogPageInfo;
import com.dlj.blog.pojo.BlogShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogDao extends BaseMapper<Blog> {
    List<BlogPageInfo> getAllBlogPageInfo();
    BlogShow getBlogById(long id);
    List<BlogPageInfo> searchBlog(String keyString);
    int updateViews(long id);
    Integer getBlogTotal();
    Integer getBlogViewTotal();
    Integer getBlogCommentTotal();
    Integer getBlogMessageTotal();
}
