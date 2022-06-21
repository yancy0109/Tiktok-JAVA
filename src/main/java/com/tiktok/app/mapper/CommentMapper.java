package com.tiktok.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentMapper {

    @Select("select count(*) from comment where video_id = #{videoId} and status = 1")
    Integer countComment(Integer videoId);
}
