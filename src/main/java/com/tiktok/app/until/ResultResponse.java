package com.tiktok.app.until;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 传入类 返回结构
 * @param <T>
 */
//implements Serializable 实现此接口的类 才能被序列化用于返回
@Data //lombok注释 自动为当前类生成getset等方法
@AllArgsConstructor //lombok注释 全参构造器
public class ResultResponse<T> implements Serializable {
    private int StatusCode;
    private String StatusMsg;
    private T Data;
}
