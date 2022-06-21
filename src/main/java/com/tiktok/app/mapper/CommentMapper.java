package com.tiktok.app.mapper;

import com.tiktok.app.bean.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment(video_id, author_id, content, create_date,  status) values (#{videoid},#{authorid},#{content},#{createdate},#{status})")
    int insertComment(Comment comment);

    @Select("select author_id from comment where comment_id= #{commentId}")
    int InquaryAuthor(Integer commentId);

    @Update("update comment set status= #{action_type}")
    int updateComment(boolean action_type);
}
