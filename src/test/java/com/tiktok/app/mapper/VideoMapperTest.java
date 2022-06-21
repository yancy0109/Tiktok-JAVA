package com.tiktok.app.mapper;


import com.tiktok.app.bean.Video;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
public class VideoMapperTest {

    @Autowired
    VideoMapper videoMapper;

    @Test
    void testuploadVideo(){
        Video video = new Video(21321,"哈哈打赏","sdasd","sdasd",new Date(),true);
        videoMapper.uploadVideo(video);
    }
    @Test
    void testselectVideoInfo(){
        Video video = videoMapper.selectVideoById(1259);
        System.out.println(video);
    }
    @Test
    void testVideoIdList(){
        ArrayList<Integer> integers = videoMapper.selectListByAuthorId(1);
        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }
}
