package com.tiktok.app.mapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
