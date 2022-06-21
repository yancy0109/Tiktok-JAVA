package com.tiktok.app.serivce;

import com.tiktok.app.response.UserInfo;
import com.tiktok.app.response.VideoInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface VideoService {
    boolean saveVideoAndCover(MultipartFile video, String videoName,String title, Integer authorId);

    ArrayList<VideoInfo> selectPublish(Integer userId, UserInfo userInfo);
}
