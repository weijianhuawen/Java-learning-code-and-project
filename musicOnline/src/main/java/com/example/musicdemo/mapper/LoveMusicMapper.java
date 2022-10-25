package com.example.musicdemo.mapper;

import com.example.musicdemo.model.LoveMusic;
import com.example.musicdemo.model.Music;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoveMusicMapper {
    //查找喜欢的音乐
    LoveMusic findLoveMusic(Integer uid, Integer mid);
    //收藏音乐
    Boolean insertLoveMusic(Integer uid, Integer mid);
    //删除音乐
    int deleteLoveMusic(Integer uid, Integer mid);
    //根据mid删除音乐
    int deleteLoveMusicByMid(Integer mid);
    // 查询所有收藏的音乐
    List<Music> findLoveMusicByUid(Integer uid);
    // 根据名称和用户id获取用户喜欢的的歌曲
    List<Music> findLoveMusicByUidAndName(String musicName, Integer uid);
}
