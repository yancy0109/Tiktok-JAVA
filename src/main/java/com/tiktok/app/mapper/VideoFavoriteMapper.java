package com.tiktok.app.mapper;

import com.tiktok.app.bean.VideoFavorite;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

@Mapper
public interface VideoFavoriteMapper {

    @Select("select count(*) from video_favorite where video_id = #{videoId} and status = 1")
    int selectVideoFavorite(Integer videoId);

    @Select("select video_id from video_favorite where user_id = #{userId} and status = 1")
    ArrayList<Integer> selectVideoIdList(Integer userId);

    @Select("select count(*) from video_favorite where video_id = #{videoId} and user_id = #{userId} and status = 1")
    int selectFavoriteStatus(Integer videoId,Integer userId);

    /**
     *
     * @param videoFavorite
     * @return
     */
    @Insert("insert into video_favorite(video_id,user_id,status,create_date) values(#{videoid},#{userid},#{status},#{createdate})")
    Integer favouriteAdd(VideoFavorite videoFavorite);

    @Update("update video_favorite set status= #{action_type} where video_id= #{videoId} and user_id = #{userId}")
    Integer favouriteUpdateAdd(Integer videoId,Integer userId,Integer action_type);

    @Select("select count(*) from video_favorite where video_id=#{videoId} and user_id=#{userId}")
    int inquery(Integer videoId,Integer userId);

}
