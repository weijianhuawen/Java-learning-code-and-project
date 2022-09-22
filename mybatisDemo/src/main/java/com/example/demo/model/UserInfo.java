package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private Integer state;
    private List<Articleinfo> aList;
}
