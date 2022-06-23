package com.tiktok.app.mapper;

import com.tiktok.app.bean.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment(video_id, author_id, content, create_date,  status) values (#{videoid},#{authorid},#{content},#{createdate},#{status})")
    int insertComment(Comment comment);
  
    @Select("select author_id from comment where id = #{commentId}")
    Integer InquaryAuthor(Integer commentId);

    @Update("update comment set status= #{action_type} where id = #{commentId}")
    Integer updateComment(Integer commentId,Integer action_type);


    @Select("select count(*) from comment where video_id = #{videoId} and status = 1")
    Integer countComment(Integer videoId);

    @Select("select comment.id from comment where video_id = #{videoId} and status = 1")
    ArrayList<Integer> getCommentList(Integer videoId);


    @Select("select video_id,author_id,content,create_date,status from comment where id = #{commentId} and status = 1")
    Comment getCommentById(Integer commentId);
}
