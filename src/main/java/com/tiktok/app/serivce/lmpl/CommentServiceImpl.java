package com.tiktok.app.serivce.lmpl;


import com.tiktok.app.bean.Comment;
import com.tiktok.app.bean.User;
import com.tiktok.app.bean.Video;
import com.tiktok.app.mapper.*;
import com.tiktok.app.response.CommentInfo;
import com.tiktok.app.response.CommentList;
import com.tiktok.app.response.UserInfo;
import com.tiktok.app.response.VideoInfo;
import com.tiktok.app.serivce.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    VideoMapper videoMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    VideoFavoriteMapper videoFavoriteMapper;
    @Autowired
    FollowMapper followMapper;

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

    @Override
    public CommentList getCommentList(Integer videoId,Integer userId, boolean hasUserId) {
        CommentList commentList = new CommentList();
        Video video = videoMapper.selectVideoById(videoId);
        if(video == null){
            return null;
        }
        int favoriteCount = videoFavoriteMapper.selectVideoFavorite(videoId);
        Integer commentCount = commentMapper.countComment(videoId);
        User author = userMapper.findUserById(video.getAuthorid());
        if(author == null){
            return null;
        }
        int follow = followMapper.countFollowCountById(author.getUserid());
        int follower = followMapper.countFollowerCountById(author.getUserid());
        boolean isFollow = false;
        boolean isFavorite = false;
        VideoInfo videoInfo;
        if (hasUserId){
            int i = followMapper.selectFollowStatus(userId, author.getUserid());
            int j = videoFavoriteMapper.selectFavoriteStatus(videoId,userId);
            isFavorite = (j==1);
            isFollow = (i==1);
             videoInfo = new VideoInfo(videoId, new UserInfo(author.getUserid(), author.getUsername(), follow, follower, isFollow),
                    video.getPlayurl(), video.getCoverurl(),
                    favoriteCount, commentCount,isFavorite,video.getTitle());
        }else {
            videoInfo = new VideoInfo(videoId,new UserInfo(author.getUserid(),author.getUsername(),follow,follower,false),
                    video.getPlayurl(),video.getCoverurl(),
                    favoriteCount,commentCount,isFavorite,video.getTitle());
        }
        commentList.setVideoInfo(videoInfo);
        commentList.setCommentInfo(new ArrayList<>());
        ArrayList<Integer> commentIdList = commentMapper.getCommentList(videoId);
        for (Integer commentId : commentIdList) {
            Comment comment = commentMapper.getCommentById(commentId);
            User user = userMapper.findUserById(comment.getAuthorid());
            UserInfo userInfo;
            if (user == null) {
                System.out.println("未查询到");
            }
            {
                userInfo = new UserInfo(comment.getAuthorid(),user.getUsername(),follow,follower,isFollow);
            }
            commentList.getCommentInfo().add(new CommentInfo(commentId,
                    userInfo,
                    comment.getContent(),comment.getCreatedate()));
        }
        return commentList;
    }
}
