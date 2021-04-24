package com.dlj.blog.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PictureDao {
    int saveAvatar(String avatar,Long id);
}
