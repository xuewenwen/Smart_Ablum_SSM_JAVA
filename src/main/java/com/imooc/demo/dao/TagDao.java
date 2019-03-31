package com.imooc.demo.dao;

import com.imooc.demo.bo.PicTag;
import com.imooc.demo.bo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TagDao {
    public Integer selectCountTag(@Param("name")String name) throws Exception;

    public void insertTag(Tag tag) throws Exception;

    public void insertPicTag(PicTag picTag)throws Exception;

}
