package com.example.demo.mapper;

import com.example.demo.model.Articleinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    //根据文章名称获取文章对象
    public Articleinfo getArticleById(@Param("id") Integer id);
}
