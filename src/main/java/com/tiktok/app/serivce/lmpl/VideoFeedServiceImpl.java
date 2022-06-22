package com.tiktok.app.serivce.lmpl;

import com.tiktok.app.bean.User;
import com.tiktok.app.bean.Video;
import com.tiktok.app.mapper.*;
import com.tiktok.app.response.UserInfo;
import com.tiktok.app.response.VideoInfo;
import com.tiktok.app.serivce.VideoFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VideoFeedServiceImpl implements VideoFeedService {

    @Autowired
    VideoMapper videoMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    VideoFavoriteMapper videoFavoriteMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    FollowMapper followMapper;

    @Override
    public ArrayList<VideoInfo> getVideoFeed(Integer userId, boolean hasUserId) {
        ArrayList<VideoInfo> videoInfos = new ArrayList<>();
        ArrayList<Integer> integers = videoMapper.videoFeed();
        for (Integer videoId : integers) {
            Video video = videoMapper.selectVideoById(videoId);
            int favoriteCount = videoFavoriteMapper.selectVideoFavorite(videoId);
            Integer commentCount = commentMapper.countComment(videoId);
            User authord = userMapper.findUserById(video.getAuthorid());
            int follow = followMapper.countFollowCountById(authord.getUserid());
            int follower = followMapper.countFollowerCountById(authord.getUserid());
            if (hasUserId){
                int i = followMapper.selectFollowStatus(userId, authord.getUserid());
                int j = videoFavoriteMapper.selectFavoriteStatus(videoId,userId);
                boolean isFollow = (i==1);
                boolean isFavorite = (j==1);
                videoInfos.add(new VideoInfo(videoId,new UserInfo(authord.getUserid(),authord.getUsername(),follow,follower,isFollow),
                        video.getPlayurl(),video.getCoverurl(),
                        favoriteCount,commentCount,isFavorite,video.getTitle()));
            }else {
                videoInfos.add(new VideoInfo(videoId,new UserInfo(authord.getUserid(),authord.getUsername(),follow,follower,false),
                        video.getPlayurl(),video.getCoverurl(),
                        favoriteCount,commentCount,false,video.getTitle()));
            }
        }
        return videoInfos;
    }
}
