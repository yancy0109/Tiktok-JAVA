package com.tiktok.app.mapper;


import com.tiktok.app.bean.Follow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
@Mapper
public interface FollowMapper {
    //根据id查询关注数
    @Select("select count(*) from follow where follow = #{userid} and is_del = 0")
    int countFollowCountById(Integer userId);
    //查询id粉丝数
    @Select("select count(*) from follow where be_follow = #{userid} and is_del = 0")
    int countFollowerCountById(Integer userId);
    //查询follow 是否关注 beFollow
    @Select("select count(*) from follow where follow = #{follow} and be_follow = #{beFollow} and is_del = 0;")
    int selectFollowStatus(Integer follow,Integer beFollow);

    //查询关注列表
    @Select("select be_follow from follow where follow = #{userId} and is_del = 0; ")
    List<Integer> getFollowList(Integer userId);

    //查询粉丝列表
    @Select("select follow from follow where be_follow = #{userId} and is_del = 0; ")
    List<Integer> getFollowerList(Integer userId);

    //首次对作者关注
    @Insert("insert into follow(be_follow, follow, is_del, update_time) VALUES (#{befollow},#{follow},#{isdel},#{updatetime})")
    int addFollow(Follow follow);
    //更新关注
    @Update("update follow set is_del=#{status},update_time=#{updatetime} where be_follow=#{befollow} and follow=#{follow} ")
    int undateFollow(Follow follow);

    //查询之前是否有关注记录
    @Select("select id from follow where be_follow=#{befollow} and follow=#{follower}")
    int inquery(Integer befollow,Integer follower);
}
