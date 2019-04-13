package com.imooc.demo.dao;

import com.imooc.demo.bo.Picture;
import com.imooc.demo.bo.RecycleSite;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class PictureDaoTest {
    @Autowired
    private PictureDao pictureDao;

    @Test
    public void Test() throws Exception {
        Picture picture = new Picture();
        picture.setAlbumId(1);
        pictureDao.insertPicture(picture);
    }
    @Test
    public void Test1() throws Exception{
        List<Picture> list = pictureDao.listPicture(1);
        System.out.println(list);
    }

    @Test
    public void TestselectUrlByTagName() throws Exception{
        //System.out.println(pictureDao.selectUrlByTagName("天空"));
        List<String> list=pictureDao.selectUrlByTagName("天空",1);
        System.out.println(list);
    }
    @Test
    public void test2() throws Exception{
        pictureDao.updatePictureStatus(50);
        RecycleSite recycleSite = new RecycleSite();
        recycleSite.setPictureId(50);
        recycleSite.setPictureDeleteTime(new Date());
        recycleSite.setUserId(1);
        pictureDao.insertRecycle(recycleSite);

    }

}