package com.tiktok.app.mapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class CommentMapperTest {

    @Autowired
    CommentMapper commentMapper;

    @Test
    void testCountCommet(){
        Integer integer = commentMapper.countComment(1250);
        System.out.println(integer);
    }

    @Test
    void testGetCommentList(){
        ArrayList<Integer> commentList = commentMapper.getCommentList(1244);
        for (Integer commentId : commentList) {
            System.out.println(commentMapper.getCommentById(commentId));
        }

    }
}
