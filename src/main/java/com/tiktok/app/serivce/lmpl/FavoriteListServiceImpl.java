package com.tiktok.app.serivce.lmpl;

import com.tiktok.app.bean.User;
import com.tiktok.app.bean.Video;
import com.tiktok.app.mapper.*;
import com.tiktok.app.response.UserInfo;
import com.tiktok.app.response.VideoInfo;
import com.tiktok.app.serivce.FavoriteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FavoriteListServiceImpl implements FavoriteListService {

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
    public List<VideoInfo> getFavoriteList(Integer userId) {
        ArrayList<VideoInfo> videoInfos = new ArrayList<>();
        ArrayList<Integer> integers = videoFavoriteMapper.selectVideoIdList(userId);
        for (Integer videoId : integers) {
            Video video = videoMapper.selectVideoById(videoId);
            int favoriteCount = videoFavoriteMapper.selectVideoFavorite(videoId);
            Integer commentCount = commentMapper.countComment(videoId);
            User authord = userMapper.findUserById(video.getAuthorid());
            int follow = followMapper.countFollowCountById(authord.getUserid());
            int follower = followMapper.countFollowerCountById(authord.getUserid());
            boolean isFollow = ((followMapper.selectFollowStatus(userId, authord.getUserid()))==1);
            videoInfos.add(new VideoInfo(videoId,new UserInfo(authord.getUserid(),authord.getUsername(),follow,follower,isFollow),
                    video.getPlayurl(),video.getCoverurl(),
                    favoriteCount,commentCount,true,video.getTitle()));
        }
        return videoInfos;
    }
}
