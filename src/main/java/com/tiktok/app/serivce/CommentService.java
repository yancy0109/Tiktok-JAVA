package com.tiktok.app.serivce;


import com.tiktok.app.response.CommentList;

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

    /**
     * 获取videoId的评论
     * @param videoId
     * @return
     */
    CommentList getCommentList(Integer videoId,Integer userId, boolean hasUserId);
}
