package com.tiktok.app.mapper;


import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentMapperTest {

    @Autowired
    CommentMapper commentMapper;

    @Test
    void testCountCommet(){
        Integer integer = commentMapper.countComment(1250);
        System.out.println(integer);
    }
}
