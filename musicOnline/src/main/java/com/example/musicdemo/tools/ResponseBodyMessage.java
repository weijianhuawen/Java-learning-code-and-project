package com.example.musicdemo.tools;


import lombok.Data;

@Data
public class ResponseBodyMessage <T> {
    //状态码
    private Integer statue;
    //返回信息
    private String message;
    //数据
    private T data;

    public ResponseBodyMessage(Integer statue, String message, T data) {
        this.statue = statue;
        this.message = message;
        this.data = data;
    }
}
