package com.dlj.blog.dao;

import com.dlj.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {
    List<Comment> searchAllComment(Long id);
    List<Comment> searchChildComment(Long id);
    int saveComment(Comment comment);
    int saveChildComment(Comment comment);
    int updateComments(long id);
}
