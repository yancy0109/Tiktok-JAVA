package com.tiktok.app.serivce.lmpl;

import com.tiktok.app.mapper.FollowMapper;
import com.tiktok.app.response.LoginAndResgiterResponese;
import com.tiktok.app.bean.User;
import com.tiktok.app.mapper.UserMapper;
import com.tiktok.app.response.UserInfo;
import com.tiktok.app.serivce.UserService;
import com.tiktok.app.until.IdUtil;
import com.tiktok.app.until.JwtUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    FollowMapper followMapper;
    @Override
    public LoginAndResgiterResponese registerUser(String userName, String passWord) {
        //生成用户id
        Integer userId = IdUtil.genId(userName);
        //userid--对应唯一username
        //查重
        User userTemp = userMapper.findUserById(userId);
        if (userTemp != null){
            return null;
        }
        //生成token
        String token = JwtUntil.generateToken(userId);
        //封装返回
        LoginAndResgiterResponese larResponse = new LoginAndResgiterResponese();
        larResponse.setToken(token);
        larResponse.setUser_id(userId);
        //数据库user对象
        User user = new User(userId,userName,passWord,userId+passWord,new Date());
        //mapper注册
        int result = userMapper.registerUser(user);
        if (result == 0) {
            return null;
        }
        return larResponse;
    }

    @Override
    public LoginAndResgiterResponese loginUser(String username, String password) {
        User userTemp = userMapper.findUserByUserName(username);
        if (userTemp == null){
            return null;
        }
        if (!userTemp.getPassword().equals(password)){
            return null;
        }
        //生成token
        String token = JwtUntil.generateToken(userTemp.getUserid());
        return new LoginAndResgiterResponese(userTemp.getUserid(),token);
    }

    @Override
    public UserInfo showUserInfo(Integer userId) {
        User user = userMapper.findUserById(userId);
        if (user == null) {
            return null;
        }
        int follow = followMapper.countFollowCountById(userId);
        int follower = followMapper.countFollowerCountById(userId);
        return new UserInfo(userId,user.getUsername(),follow,follower,false);
    }
}
