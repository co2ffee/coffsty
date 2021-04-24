package com.dlj.blog.service;

import com.dlj.blog.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> searchAllComment(Long id);
    int saveComment(Comment comment);
}
