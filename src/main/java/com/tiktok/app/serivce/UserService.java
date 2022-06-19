package com.tiktok.app.serivce;

import com.tiktok.app.response.LoginAndResgiterResponese;

public interface UserService {

    //根据传入username,password注册用户
    LoginAndResgiterResponese registerUser(String username, String password);
    //根据传入username,password登录用户
    LoginAndResgiterResponese loginUser(String username, String password);
}
