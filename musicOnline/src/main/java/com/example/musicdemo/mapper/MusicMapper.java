package com.example.musicdemo.mapper;

import com.example.musicdemo.model.Music;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicMapper {
    int insertMusic(Music music);
    Music selectMusicByTitleAndSinger(String title, String singer);
    Music findMusicById(Integer mid);
    //删除音乐
    int deleteMusicById(Integer mid);
    //查询所有的音乐
    List<Music> selectAllMusic();
    //根据歌曲名模糊查询音乐
    List<Music> selectIgnoreMusicByTitle(String title);
}
