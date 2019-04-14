package com.imooc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.imooc.demo.bo.Picture;
import com.imooc.demo.bo.RecycleSite;
import com.imooc.demo.dao.PictureDao;
import com.imooc.demo.service.PictureService;
import com.imooc.demo.utils.PageBean;
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

    @Override
    public List<Picture> listPictureByPage(int currentPage, int pageSize,int id) throws Exception {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<Picture> picturesList = pictureDao.listPicture(id);
        int count = pictureDao.listPictureCount(id);
        PageBean<Picture> pageData = new PageBean<>(currentPage, pageSize, count);
        pageData.setItems(picturesList);
        return pageData.getItems();
    }

}
