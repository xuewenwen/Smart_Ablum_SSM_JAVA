package com.imooc.demo.service.impl;

import com.imooc.demo.dao.PictureDao;
import com.imooc.demo.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureDao pictureDao;

    @Override
    public List<String> selectUrlByTagName(String tagName) {
        return pictureDao.selectUrlByTagName(tagName);
    }
}
