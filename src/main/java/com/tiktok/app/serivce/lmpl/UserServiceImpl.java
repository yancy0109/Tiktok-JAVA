package com.tiktok.app.serivce.lmpl;

import com.tiktok.app.bean.User;
import com.tiktok.app.mapper.UserMapper;
import com.tiktok.app.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public void registerUser(String username, String password) {
        User user = new User(123123,username,password,"sdasd",new Date());
        userMapper.registerUser(user);
    }
}
