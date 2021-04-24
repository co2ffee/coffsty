package com.dlj.blog.dao;

import com.dlj.blog.entity.Flag;
import com.dlj.blog.pojo.BlogPageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeDao {
    List<BlogPageInfo> getTypeBlogPageInfo(long flagId);
    List<Flag> getAllFlag();
}
