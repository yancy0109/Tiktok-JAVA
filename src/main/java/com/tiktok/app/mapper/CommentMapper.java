package com.tiktok.app.mapper;

import com.tiktok.app.bean.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    
    @Insert("insert into comment(video_id, author_id, content, create_date,  status) values (#{videoid},#{authorid},#{content},#{createdate},#{status})")
    int insertComment(Comment comment);
  
    @Select("select count(*) from comment where video_id = #{videoId} and status = 1")
    Integer countComment(Integer videoId);
}
