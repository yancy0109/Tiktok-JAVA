package com.tiktok.app.mapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FollowMapperTest {
    @Autowired
    FollowMapper followMapper;
    @Test
    public void testFollowCount(){
        System.out.println(followMapper.countFollowCountById(1));
    }
    @Test
    public void testFollowerCount(){
        System.out.println(followMapper.countFollowerCountById(1));
    }

    @Test
    public void testSelectFollowStatus(){
        System.out.println(followMapper.selectFollowStatus(1,3));
    }

    @Test
    public void getFollowList(){
        List<Integer> followList = followMapper.getFollowList(2);
        for (Integer integer : followList) {
            System.out.println(integer);
        }
    }
    @Test
    public void getFollowerList(){
        List<Integer> followList = followMapper.getFollowerList(1);
        for (Integer integer : followList) {
            System.out.println(integer);
        }
    }
}
