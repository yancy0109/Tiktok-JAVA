package com.tiktok.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface VideoFavoriteMapper {

    @Select("select count(*) from video_favorite where video_id = #{videoId} and status = 1")
    int selectVideoFavorite(Integer videoId);

    @Select("select video_id from video_favorite where user_id = #{userId} and status = 1")
    ArrayList<Integer> selectVideoIdList(Integer userId);
}
