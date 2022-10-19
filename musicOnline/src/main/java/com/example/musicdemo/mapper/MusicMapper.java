package com.example.musicdemo.mapper;

import com.example.musicdemo.model.Music;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MusicMapper {
    int insertMusic(Music music);
    Music selectMusicByTitleAndSinger(String title, String singer);
    Music findMusicById(Integer mid);
    //删除音乐
    int deleteMusicById(Integer mid);
}
