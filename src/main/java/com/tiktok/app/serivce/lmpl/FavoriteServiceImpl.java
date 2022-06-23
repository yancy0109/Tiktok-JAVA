package com.tiktok.app.serivce.lmpl;

import com.tiktok.app.bean.Comment;
import com.tiktok.app.bean.VideoFavorite;
import com.tiktok.app.mapper.VideoFavoriteMapper;
import com.tiktok.app.serivce.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author bai
 * @version 1.0
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    VideoFavoriteMapper videoFavoriteMapper;

    @Override
    public boolean favoriteAdd(Integer videoId, Integer userId, Integer status) {
        int result = videoFavoriteMapper.favouriteAdd(new VideoFavorite(videoId,userId,status,new Date()));
        if (result==0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean favoriteUpdateAdd(Integer videoId, Integer userId, Integer status) {
        int result = videoFavoriteMapper.favouriteUpdateAdd(videoId,userId,status);
        if (result==0) {
            return false;
        }
        return true;
    }
}
