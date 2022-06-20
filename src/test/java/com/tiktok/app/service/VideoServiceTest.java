package com.tiktok.app.service;


import com.tiktok.app.until.VideoUntil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VideoServiceTest {

    @Test
    public void saveCover(){
        VideoUntil.saveCover("test.mp4");
    }
}
