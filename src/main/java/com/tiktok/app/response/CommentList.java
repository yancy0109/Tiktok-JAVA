package com.tiktok.app.response;


import lombok.Data;

import java.util.ArrayList;

@Data
public class CommentList {
    VideoInfo videoInfo;
    ArrayList<CommentInfo> commentInfo;
}
