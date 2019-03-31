package com.imooc.demo.dao;

import com.imooc.demo.bo.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface PictureDao {
    public List<String> selectUrlByTagName(@Param("tagName") String tagName,@Param("id")Integer id);
    Picture getPicture(@Param("pictureId") int pictureId) throws Exception;
    List<Picture> listPicture(@Param("userId") int pictureId) throws Exception;
    void insertPicture(@Param("picture") Picture picture) throws Exception;
}
