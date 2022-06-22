package com.tiktok.app.serivce.lmpl;

import com.tiktok.app.bean.User;
import com.tiktok.app.bean.Video;
import com.tiktok.app.mapper.*;
import com.tiktok.app.response.UserInfo;
import com.tiktok.app.response.VideoInfo;
import com.tiktok.app.serivce.VideoService;
import com.tiktok.app.until.VideoUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    VideoMapper videoMapper;
    @Autowired
    VideoFavoriteMapper videoFavoriteMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    FollowMapper followMapper;

    @Override
    public boolean saveVideoAndCover(MultipartFile video,String videoName,String title,Integer authorId) {
        if (!VideoUntil.saveVideo(video, videoName)){
            return false;
        }
        if (!VideoUntil.saveCover(videoName)){
            return false;
        }
        String videoPath = "/video/"+videoName;
        String coverPath = "/cover/"+videoName+".jpg";
        int result = videoMapper.uploadVideo(new Video(authorId, title, videoPath, coverPath, new Date(), true));
        return result != 0;
    }

    @Override
    //查询用户自己的发布列表
    public ArrayList<VideoInfo> selectPublish(Integer userId,UserInfo userInfo) {
        ArrayList<VideoInfo> videoInfos = new ArrayList<>();
        ArrayList<Integer> integers = videoMapper.selectListByAuthorId(userId);
        User user = userMapper.findUserById(userId);
        if (user == null){
            return null;
        }
        for (Integer videoId : integers) {
            Video video = videoMapper.selectVideoById(videoId);
            int favoriteCount = videoFavoriteMapper.selectVideoFavorite(videoId);
            Integer commentCount = commentMapper.countComment(videoId);
            int j = videoFavoriteMapper.selectFavoriteStatus(videoId,userId);
            boolean isFavorite = (j==1);
            videoInfos.add(new VideoInfo(videoId,userInfo,video.getPlayurl(),video.getCoverurl(),
                    favoriteCount,commentCount,isFavorite,video.getTitle()));
        }
        return videoInfos;
    }
}
