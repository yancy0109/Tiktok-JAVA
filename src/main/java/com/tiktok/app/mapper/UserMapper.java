package com.tiktok.app.mapper;

import com.tiktok.app.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    //注册
    @Insert("insert into douyin.user(user_id, user_name, password, salt, create_date) values (#{userid},#{username},#{password},#{salt},#{createdate});")
    void registerUser(User user);
    //查询

    @Select("select user_id, user_name, password, salt, create_date from douyin.user where user_id = #{userid}")
    User findUserById(Integer userid);

    @Select("select user_id, user_name, password, salt, create_date from douyin.user where user_name = #{username}")
    User findUserByUserName(String username);
}
