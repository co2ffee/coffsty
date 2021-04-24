package com.dlj.blog.service.Impl;

import com.dlj.blog.dao.CommentDao;
import com.dlj.blog.entity.Comment;
import com.dlj.blog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;
    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();

    @Override
    public List<Comment> searchAllComment(Long id) {
        //查询出父节点
        List<Comment> comments = commentDao.searchAllComment(id);
        for (Comment comment : comments) {
            Long childId = comment.getId();
            String parentNickname = comment.getNickname();
            List<Comment> childComments = commentDao.searchChildComment(childId);
            //查询出子留言
            selectChildComment(childComments, parentNickname);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }

    private void selectChildComment(List<Comment> childComments, String parentNickname) {
        //判断是否有一级子回复
        if (childComments.size() > 0) {
            //循环找出子留言的id
            for (Comment childComment : childComments) {
                String childParentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
                //根据id查询二级以及所有子集回复
                recursively(childId, childParentNickname);
            }
        }
    }

    private void recursively(Long childId, String childParentNickname) {
        //根据子一级留言的id找到子二级留言
        List<Comment> replayComments = commentDao.searchChildComment(childId);

        if (replayComments.size() > 0) {
            for (Comment replayComment : replayComments) {
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(childParentNickname);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                //循环迭代找出子集回复
                recursively(replayId, parentNickname);
            }
        }
    }

    @Override
    public int saveComment(Comment comment) {
        //当前日期
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowDate = dateTime.format(formatter);

        log.info("nowDate:{}", nowDate);
        comment.setCreateTime(Timestamp.valueOf(nowDate));

        int f1, f2;
        if (comment.getParentCommentId() == -1) {
            f1 = commentDao.saveComment(comment);
            f2 = commentDao.updateComments(comment.getBlogId());
            f1 = f1 * f2;
        } else {
            f1 = commentDao.saveChildComment(comment);
        }
        return f1;
    }
}
