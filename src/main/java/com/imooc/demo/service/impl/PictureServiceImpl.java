package com.imooc.demo.service.impl;

import com.imooc.demo.bo.Picture;
import com.imooc.demo.bo.RecycleSite;
import com.imooc.demo.dao.PictureDao;
import com.imooc.demo.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {

    @Autowired
    PictureDao pictureDao;


    @Override
    public void insertPicture(Picture picture) throws Throwable {

        pictureDao.insertPicture(picture);
    }
    @Override
    public List<String> selectUrlByTagName(String tagName,Integer id) {
        return pictureDao.selectUrlByTagName(tagName,id);
    }

    @Override
    public List<Picture> listPicture(Integer id) throws Exception {
        return pictureDao.listPicture(id);
    }

    @Override
    public void deletePicture(Integer id, RecycleSite recycleSite) throws Exception {
        pictureDao.updatePictureStatus(id);
        pictureDao.insertRecycle(recycleSite);
    }

    @Override
    public Integer selectPictureId(String name) throws Exception {
        return pictureDao.selectPictureId(name);
    }

}
