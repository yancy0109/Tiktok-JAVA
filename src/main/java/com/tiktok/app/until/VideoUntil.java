package com.tiktok.app.until;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class VideoUntil {
    //初始化文件保存目录
    static {
        File checkVideoPath = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static\\video");
        File checkCoverPath = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static\\cover");
        if (!checkCoverPath.exists()){
            boolean mkdir = checkCoverPath.mkdir();
        }
        if (!checkVideoPath.exists()){
            checkVideoPath.mkdir();
        }
    }
    //保存视频
    public static boolean saveVideo(MultipartFile file,String videoname){
        //获取当前部署位置静态资源目录
        String savePath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static\\video\\";
        try {
            file.transferTo(new File(savePath+videoname));
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    //保存封面
    public static boolean saveCover(String videoName){
        //获取当前部署位置静态资源目录
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static";
        String videoPath = path+"/video/"+videoName;
        String coverPath = path+"/cover/"+videoName+".jpg";
        ArrayList<String> command = new ArrayList<>();
        command.add("ffmpeg");
        command.add("-y");
        command.add("-i");
        command.add(new File(videoPath).toString());
        command.add("-r");
        command.add("1");
        command.add("-s");
        command.add("400x600");
        command.add("-vframes");
        command.add("1");
        command.add(new File(coverPath).toString());
        //命令输出
//        System.out.println(command);
        //执行操作
        ProcessBuilder builder = new ProcessBuilder();
        builder.redirectErrorStream(true);
        //设置命令执行位置 即video及cover保存位置
        //以后会换到配置文件
        builder.command(command).directory(new File(path));
        try {
            Process process = builder.start();
            InputStream inputStream = process.getInputStream();
            inputStream.close();
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
