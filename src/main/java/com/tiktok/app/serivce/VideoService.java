package com.tiktok.app.serivce;

import org.springframework.web.multipart.MultipartFile;

public interface VideoService {
    boolean saveVideoAndCover(MultipartFile video, String videoName,String title, Integer authorId);
}
