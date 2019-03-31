package com.imooc.demo.service.impl;

import com.imooc.demo.bo.Picture;
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
    public Picture getPicture(int pictureId) throws Exception {
       return pictureDao.getPicture(pictureId);
    }

    @Override
    public List<Picture> listPicture(int userId) throws Exception {
        return pictureDao.listPicture(userId);
    }

    @Override
    public void insertPicture(Picture picture) throws Throwable {

        pictureDao.insertPicture(picture);
    }

}
