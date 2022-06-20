package com.tiktok.app.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FollowMapper {
    //根据id查询关注数
    @Select("select count(*) from follow where follow = #{userid}")
    int countFollowCountById(Integer userId);
    //查询id粉丝数
    @Select("select count(*) from follow where be_follow = #{userid}")
    int countFollowerCountById(Integer userId);
    //查询follow 是否关注 beFollow
    @Select("select is_del from follow where follow = #{follow} and be_follow = #{beFollow}")
    int selectFollowStatus(Integer follow,Integer beFollow);
}
