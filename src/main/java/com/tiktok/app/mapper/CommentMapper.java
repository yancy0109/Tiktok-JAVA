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

    @Select("select author_id from comment where id= #{commentId}")
    int InquaryAuthor(Integer commentId);

    @Update("update comment set status= #{action_type} where id=#{commentId}")
    int updateComment(Integer commentId,Integer action_type);


    @Select("select count(*) from comment where video_id = #{videoId} and status = 1")
    Integer countComment(Integer videoId);
}
