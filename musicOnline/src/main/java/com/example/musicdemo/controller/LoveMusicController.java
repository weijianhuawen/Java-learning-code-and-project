package com.example.musicdemo.controller;

import com.example.musicdemo.mapper.LoveMusicMapper;
import com.example.musicdemo.mapper.MusicMapper;
import com.example.musicdemo.model.LoveMusic;
import com.example.musicdemo.model.Music;
import com.example.musicdemo.model.UserLogin;
import com.example.musicdemo.tools.Constant;
import com.example.musicdemo.tools.ResponseBodyMessage;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("lovemusic")
@Slf4j
public class LoveMusicController {

    //lovemusicmapper
    @Resource
    private LoveMusicMapper loveMusicMapper;

    @Resource
    private MusicMapper musicMapper;


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
        //查询曲库是否含有此id的歌曲，如果不存在收藏失败
        Music music = musicMapper.findMusicById(mid);

        //没有找到 收藏失败
        if (music == null) {
            log.info("曲库歌曲不存在!");
            return new ResponseBodyMessage<>(-1, "曲库不存在该歌曲！", false);
        }

        //查询收藏歌单
        LoveMusic loveMusic = loveMusicMapper.findLoveMusic(uid, mid);
        if (loveMusic == null) {
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

    @RequestMapping("findlove")
    public ResponseBodyMessage<List<Music>> findLoveMusic(@RequestParam(required = false) String musicName, HttpServletRequest req) {
        //登录验证
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(Constant.USERINFO_SESSION_KEY) == null) {
            return new ResponseBodyMessage<>(-1, "用户未登录!", null);
        }

        //获取user
        UserLogin user = (UserLogin) session.getAttribute(Constant.USERINFO_SESSION_KEY);
        //获取ID
        Integer uid = user.getUid();

        if (musicName == null || musicName.length() == 0) {
            //关键字为null查询整个收藏列表
            List<Music> musics = loveMusicMapper.findLoveMusicByUid(uid);
            //查询到所有歌曲
            log.info("查询到所有歌曲！");
            return new ResponseBodyMessage<>(1, "已经查询所有歌曲!", musics);
        } else {
            //不为空查找指定名字的歌曲，模糊匹配
            List<Music> musics = loveMusicMapper.findLoveMusicByUidAndName(musicName,uid);
            return new ResponseBodyMessage<>(1, "查询结果如下!", musics);
        }

    }

    //移除请求
    @RequestMapping("removelove")
    public ResponseBodyMessage<Boolean> removeLoveMusic(Integer mid, HttpServletRequest req) {
        //登录验证
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(Constant.USERINFO_SESSION_KEY) == null) {
            return new ResponseBodyMessage<>(-1, "用户未登录!", null);
        }

        //移除收藏的音乐
        //或uid
        UserLogin user = (UserLogin) session.getAttribute(Constant.USERINFO_SESSION_KEY);
        Integer uid = user.getUid();

        //移除音乐
        int res = loveMusicMapper.deleteLoveMusic(uid, mid);
        if (res != 0) {
            return new ResponseBodyMessage<>(1, "删除成功!", true);
        }
        return new ResponseBodyMessage<>(-1, "删除失败,可能不存在该音乐!", false);
    }
}
