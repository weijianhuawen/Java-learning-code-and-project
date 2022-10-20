package com.example.musicdemo.mapper;

import com.example.musicdemo.model.Music;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoveMusicMapper {
    //查找喜欢的音乐
    Music findLoveMusic(Integer uid, Integer mid);
    //收藏音乐
    Boolean insertLoveMusic(Integer uid, Integer mid);
    //删除音乐
    int deleteLoveMusic(Integer uid, Integer mid);
}
