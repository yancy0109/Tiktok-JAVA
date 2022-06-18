package com.tiktok.app;

import com.tiktok.app.bean.User;
import com.tiktok.app.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void testRegisterUser(){
        userMapper.registerUser(new User(123123,"ha","wda","12312",new Date()));
    }
}
