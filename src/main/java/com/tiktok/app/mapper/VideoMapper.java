package com.tiktok.app.mapper;

import com.tiktok.app.bean.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoMapper {
    @Insert("insert into video(author_id, title, play_url, cover_url, create_date, status) values (#{authorid},#{title},#{playurl},#{coverurl},#{createdate},#{status})")
    void uploadVideo(Video video);
}
