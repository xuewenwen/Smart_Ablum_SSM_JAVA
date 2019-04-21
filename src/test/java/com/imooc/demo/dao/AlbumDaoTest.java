package com.imooc.demo.dao;

import com.imooc.demo.bo.Album;
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
public class AlbumDaoTest {
    @Autowired
    private AlbumDao albumDao;
    @Test
    public void test() throws Exception {
        List<Album> list=albumDao.selectAlbumByUserId(1);
        System.out.println(list);
    }

    @Test
    public void test211(){
        albumDao.modifyURL("111",102,1);
        System.out.print("111111111111111111111111111111111111111");
    }

    @Test
    public  void test1 (){
        Album album = new Album();
        album.setAlbumCover("11111");
        album.setUserId(1);
        album.setAlbumName("111");
        album.setAlbumCreateTime(new Date());
        album.setAlbumDescription("hhhh");
        albumDao.insertAlbum(album);
        System.out.println("----------------------------");
    }

}