package com.example.musicdemo.controller;


import com.example.musicdemo.mapper.LoveMusicMapper;
import com.example.musicdemo.model.Music;
import com.example.musicdemo.model.UserLogin;
import com.example.musicdemo.tools.Constant;
import com.example.musicdemo.tools.ResponseBodyMessage;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("lovemusic")
public class LoveMusicController {

    //lovemusicmapper
    @Resource
    private LoveMusicMapper loveMusicMapper;


    //收藏音乐/取消收藏音乐
    @RequestMapping("love")
    public ResponseBodyMessage<Boolean> addOrDelLoveMusic(@RequestParam Integer mid,
                                                          HttpServletRequest req) {
        //非空校验
        //登录验证
        //获取Session
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(Constant.USERINFO_SESSION_KEY) == null) {
            return new ResponseBodyMessage<>(-1, "用户未登录!", false);
        }

        //获取User
        UserLogin user = (UserLogin) session.getAttribute(Constant.USERINFO_SESSION_KEY);
        //获取uid
        Integer uid = user.getUid();

        //查询收藏歌单
        Music music = loveMusicMapper.findLoveMusic(uid, mid);
        if (music == null) {
            //没有收藏
            Boolean res = loveMusicMapper.insertLoveMusic(uid, mid);
            return  new ResponseBodyMessage<>(1, "收藏成功", true);
        } else {
            //已经收藏则取消收藏
            int delRes = loveMusicMapper.deleteLoveMusic(uid, mid);

            if (delRes == 0) {
                //删除失败
                return new ResponseBodyMessage<>(-1, "取消收藏失败！", false);
            }

            return new ResponseBodyMessage<>(1, "取消收藏成功", true);
        }
    }
}
