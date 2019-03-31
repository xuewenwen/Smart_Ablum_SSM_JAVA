package com.imooc.demo.service.impl;

import com.imooc.demo.bo.PicTag;
import com.imooc.demo.bo.Tag;
import com.imooc.demo.dao.TagDao;
import com.imooc.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public void insertTag(String name,Integer id) throws Exception {
        PicTag picTag = new PicTag();
        Tag tag = new Tag();
        //String name = "小猪";
        Integer num = tagDao.selectCountTag(name);
        if(num!=null){
            picTag.setPictureId(id);
            picTag.setTagId(num);
            tagDao.insertPicTag(picTag);
        }
        else{
            tag.setTagName(name);
            tagDao.insertTag(tag);
            picTag.setPictureId(id);
            picTag.setTagId(tagDao.selectCountTag(name));
            tagDao.insertPicTag(picTag);
        }
    }
}
