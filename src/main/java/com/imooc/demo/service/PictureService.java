package com.imooc.demo.service;


import com.imooc.demo.bo.Picture;

import java.util.List;

public interface PictureService {
    Picture getPicture(int pictureId) throws Exception;
    List<Picture> listPicture(int userId) throws Exception;
    void insertPicture(Picture picture) throws Throwable;
    public List<String> selectUrlByTagName(String tagName,Integer id);
}
