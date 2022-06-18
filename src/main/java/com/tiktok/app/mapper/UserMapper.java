package com.tiktok.app.mapper;

import com.tiktok.app.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;


@Mapper
public interface UserMapper {

    //注册
    @Insert("insert into douyin.user(user_id, user_name, password, salt, create_date) values (#{userid},#{username},#{password},#{salt},#{date});")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void registerUser(User user);
}
