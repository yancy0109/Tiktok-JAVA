package com.tiktok.app.serivce.lmpl;


import com.tiktok.app.bean.Comment;
import com.tiktok.app.mapper.CommentMapper;
import com.tiktok.app.serivce.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public boolean saveComment(Integer authorId, Integer videoId, Integer actionType, String context) {
        int result = commentMapper.insertComment(new Comment(videoId,authorId,context,new Date(),actionType));
        if (result == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteComment(Integer authorId, Integer videoId, Integer commentId,Integer actionType) {
        int author= commentMapper.InquaryAuthor(commentId);

        int result = commentMapper.updateComment(commentId,actionType);
        if (author!=authorId||result == 0) {
            return false;
        }
        return true;
    }



}
