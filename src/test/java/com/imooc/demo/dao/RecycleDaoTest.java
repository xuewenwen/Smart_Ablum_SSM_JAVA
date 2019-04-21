package com.imooc.demo.dao;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class RecycleDaoTest {
    @Autowired
    private RecycleDao recycleDao;

    @Test
    public void testSelectAllPicture() throws Exception {
        List<Map<String,Object>> list = recycleDao.selectAllPicture(1);
        System.out.println(list);
    }
    @Test
    public void test() throws Exception{
        Integer id=recycleDao.selectRecyclePictureId(6);
        recycleDao.deleteRecycleById(6);
        recycleDao.deletePictureById(id);
    }
    @Test
    public void test1(){
        Map<String,Object> map = recycleDao.selectPicAlbum(60);
        System.out.println(map);
    }



}