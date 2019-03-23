package com.imooc.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PictureDao {
    public List<String> selectUrlByTagName(String tagName);

}
