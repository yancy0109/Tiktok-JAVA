package com.tiktok.app.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class VideoFavoriteMapperTest {

    @Autowired
    VideoFavoriteMapper videoFavoriteMapper;

    @Test
    public void testSelectFav(){
        int count = videoFavoriteMapper.selectVideoFavorite(1244);
        System.out.println(count == 2?"正确":"错误");
    }
    @Test
    void testSelectVideoIdList(){
        ArrayList<Integer> integers = videoFavoriteMapper.selectVideoIdList(1);
        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }
}
