package com.tiktok.app.mapper;

import com.tiktok.app.bean.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface VideoMapper {
    @Insert("insert into video(author_id, title, play_url, cover_url, create_date, status) values (#{authorid},#{title},#{playurl},#{coverurl},#{createdate},#{status})")
    int uploadVideo(Video video);

    @Select("select author_id, title, play_url, cover_url, create_date, status from video where id = #{videoId}")
    Video selectVideoById(Integer videoId);

    @Select("select video.id from video where video.author_id = #{authorid}")
    ArrayList<Integer> selectListByAuthorId(Integer authorid);
}
