package com.imooc.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PictureDao {
    public List<String> selectUrlByTagName(@Param("tagName") String tagName,@Param("id")Integer id);

}
