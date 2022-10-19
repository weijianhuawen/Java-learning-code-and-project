package com.example.musicdemo.controller;


import com.example.musicdemo.mapper.MusicMapper;
import com.example.musicdemo.model.Music;
import com.example.musicdemo.model.UserLogin;
import com.example.musicdemo.tools.Constant;
import com.example.musicdemo.tools.ResponseBodyMessage;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("music")
@ResponseBody
@RestController
@Slf4j
public class MusicController {
    //文件存储路径
//    private String savePath = "D:/未见花闻/项目/在线音乐平台/music/";
    //从配置文件中读取

    @Resource
    MusicMapper musicMapper;

    @Value("${music.local.path}")
    private String savePath;

    @RequestMapping("upload")
    public ResponseBodyMessage<Boolean> insertMusic(@RequestParam String singer,
                                                    @RequestParam("filename") MultipartFile file,
                                                    HttpServletRequest req) {
        //检查是否登录
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(Constant.USERINFO_SESSION_KEY) == null) {
            System.out.println("用户没有登录!");
            return new ResponseBodyMessage<>(-2, "用户没有登录，请登录再进行上传!", false);

        }



        String filename = file.getOriginalFilename();//获取文件的名称

        System.out.println("上传文件名：" + filename);

        //上传路径
        String path = savePath + filename;
        File dest = new File(path);

        if (!dest.exists()) {
            dest.mkdir();
        }

        //检查数据库中是否有同一首歌曲 此处判断的逻辑为 歌名与歌手名是否重复，如果两个都重复则不进行插入
        //标题 1.获取最后一个.的下标 2.截取该.前面的字符
        int lastIndex = filename.lastIndexOf(".");
        String title = filename.substring(0, lastIndex);

        Music musicDemo = musicMapper.selectMusicByTitleAndSinger(title, singer);

        if (musicDemo != null) {
            //歌曲重复
            return new ResponseBodyMessage<>(-3, "歌曲已经存在!", false);
        }

        try {
            file.transferTo(dest);
            //return new ResponseBodyMessage<>(2, "上传成功!", true);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseBodyMessage<>(-2, "上传失败!", false);
        }
        //数据持久化
        //准备数据

        //歌手 传入数据
        //上传时间 当前时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sf.format(new Date());
        //请求路径
        String url = "/music/get?path=" + title;
        //上传用户id 通过Session获取
        UserLogin userLogin = (UserLogin) req.getSession().getAttribute(Constant.USERINFO_SESSION_KEY);
        Integer userId = userLogin.getUid();
        //准备数据的存储
        Music music = new Music();
        music.setTitle(title);
        music.setSinger(singer);
        music.setTime(time);
        music.setUrl(url);
        music.setUserid(userId);


        try {
            int ret = musicMapper.insertMusic(music);

            if (ret == 1) {
                //上传成功
                //重定向到音乐列表页
                return new ResponseBodyMessage<>(2, "上传成功!", true);
            } else {
                //上传失败
                return new ResponseBodyMessage<>(-2, "数据库上传失败!", false);
            }
        } catch (BindException e) {
            //删除服务器上的文件
            dest.delete();
            e.printStackTrace();
            return new ResponseBodyMessage<>(-2, "数据库上传失败!", false);
        }
    }

    //根据id删除音乐
    @RequestMapping("delete")
    public ResponseBodyMessage<Boolean> delete(@RequestParam Integer id) {
        //非空校验
        //登录验证

        //使用标题和歌手查询
        Music music = musicMapper.findMusicById(id);
        if (music == null) {
            //没有查询到
            return new ResponseBodyMessage<>(-4, "曲库中没有该歌曲!", false);
        }

        //找到了，删除路径下的歌曲和数据库记录

        int ret = musicMapper.deleteMusicById(id);
        if (ret == 1) {
            //数据库数据成功，继续删除服务器端的文件
            //获取url字符串中第一个等于号后面的标题
            int index = music.getUrl().indexOf("=");
            String filename = music.getUrl().substring(index + 1);

            File file = new File(savePath + filename + ".mp3");
            log.info("正在删除歌曲[" + filename + "]");

            if (file.delete()) {
                //删除成功
                log.info(filename + "删除成功!");
                return new ResponseBodyMessage<>(1, "已将" + filename + "从曲库中删除", true);
            } else {
                return new ResponseBodyMessage<>(-1, "删除失败！可能是路径出现了问题!", false);
            }
        }

        return new ResponseBodyMessage<>(-1, "删除失败！可能是数据库删除数据时出现了问题!", false);
    }

    //批量删除音乐

    @RequestMapping("get")
    public ResponseEntity<byte[]> getMusic(String path) {
        //非空校验
        if (path == null || path.length() == 0) {
            return null;
        }

        File file = new File(savePath + path);
        byte[] res = null;

        try {
            res = Files.readAllBytes(file.toPath());
            //获取失败返回失败
            if (res == null) return ResponseEntity.badRequest().build();

            return ResponseEntity.ok(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

}
