package com.example.musicdemo.model;

import lombok.Data;

@Data
public class Music {
    private Integer mid;
    private String title;
    private String singer;
    private String url;
    private String time;
    private Integer userid;
}
