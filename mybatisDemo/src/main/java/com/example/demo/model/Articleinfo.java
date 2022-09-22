package com.example.demo.model;

import lombok.Data;

@Data
public class Articleinfo {
    private Integer id;
    private String title;
    private String content;
    private String createtime;
    private String updatetime;
    private Integer uid;
    private Integer rcount;
    private Integer state;
    //不妨多一个属性，用户表
    private UserInfo userInfo;
}
