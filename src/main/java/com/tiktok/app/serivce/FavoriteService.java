package com.tiktok.app.serivce;

/**
 * @author bai
 * @version 1.0
 */
public interface FavoriteService {
    /**
     * 用户进行点赞操作
     * @return
     */
    boolean favoriteAdd(Integer videoId,Integer userId,Integer status);
    /**
     * 用户取消点赞操作
     */
    boolean favoriteUnAdd(Integer videoId,Integer userId,Integer status);



}
