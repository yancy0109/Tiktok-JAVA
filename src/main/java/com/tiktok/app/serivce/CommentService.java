package com.tiktok.app.serivce;

import org.springframework.web.multipart.MultipartFile;

public interface CommentService {
    /**
     * 用户进行评论，并保存到数据库。
     * @param authorId
     * @return
     */
    boolean saveComment(Integer authorId,Integer videoId,boolean actionType,String context);

    /**
     * 用户对评论进行删除操作
     */
    boolean deleteComment(Integer authorId,Integer videoId,Integer commentId,boolean actionType);

}
