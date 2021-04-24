package com.dlj.blog.service;

import com.dlj.blog.entity.Flag;
import com.dlj.blog.pojo.BlogPageInfo;

import java.util.List;

public interface TypeService {
    List<BlogPageInfo> getTypeBlogPageInfo(String flagId);
    List<Flag> getAllFlag();
}
