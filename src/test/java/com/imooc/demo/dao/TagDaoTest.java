package com.imooc.demo.dao;

import com.imooc.demo.bo.PicTag;
import com.imooc.demo.bo.Tag;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class TagDaoTest {
    @Autowired
    private TagDao tagDao;

    PicTag picTag = new PicTag();
    Tag tag = new Tag();
    @Test
    public void Test() throws Exception {
        String name = "小猪";
        Integer num = tagDao.selectCountTag(name);
        if(num!=null){
            picTag.setPictureId(14);
            picTag.setTagId(num);
            tagDao.insertPicTag(picTag);
        }
        else{
            tag.setTagName(name);
            tagDao.insertTag(tag);
            picTag.setPictureId(14);
            picTag.setTagId(tagDao.selectCountTag(name));
            tagDao.insertPicTag(picTag);
        }
    }

}