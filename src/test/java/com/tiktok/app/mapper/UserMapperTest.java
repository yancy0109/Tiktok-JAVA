package com.tiktok.app.mapper;

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

    @Test
    public void testSelectUserById(){
        User user = userMapper.findUserById(2222);
        System.out.println(user==null?"不存在":"存在");
    }
    @Test
    public void testSelectUserByUserName(){
        User user = userMapper.findUserByUserName("admixxn");
        System.out.println(user==null?"不存在":"存在");
    }
}
