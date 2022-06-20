package com.tiktok.app.serivce.lmpl;

import com.tiktok.app.bean.Video;
import com.tiktok.app.mapper.VideoMapper;
import com.tiktok.app.serivce.VideoService;
import com.tiktok.app.until.VideoUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;
    @Override
    public boolean saveVideoAndCover(MultipartFile video,String videoName,String title,Integer authorId) {
        if (!VideoUntil.saveVideo(video, videoName)){
            return false;
        }
        if (!VideoUntil.saveCover(videoName)){
            return false;
        }
        String videoPath = "/video/"+videoName;
        String coverPath = "/video/"+videoName+".jpg";
        int result = videoMapper.uploadVideo(new Video(authorId, title, videoPath, coverPath, new Date(), true));
        if (result == 0)    return false;
        return true;
    }
}
