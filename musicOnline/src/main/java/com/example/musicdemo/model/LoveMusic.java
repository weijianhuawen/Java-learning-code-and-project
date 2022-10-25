package com.example.musicdemo.model;

import lombok.Data;

@Data
public class LoveMusic {
    private Integer id;
    private Integer user_id;
    private Integer music_id;
    private Music music;
}
