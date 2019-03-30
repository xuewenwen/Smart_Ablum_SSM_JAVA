package com.imooc.demo.service.impl;

import com.imooc.demo.dao.RecycleDao;
import com.imooc.demo.service.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class RecycleServiceImpl implements RecycleService {
    @Autowired
    private RecycleDao recycleDao;
    @Override
    public List<Map<String, Object>> selectAllPicture(Integer id) throws Exception {
        return recycleDao.selectAllPicture(id);
    }

    @Override
    public void updatePictureStatus(Integer id) throws Exception {
        //更新照片的状态
        recycleDao.updatePictureStatus(id);
        //删除回收站中的记录
        recycleDao.deleteRecycleById(id);
    }

    @Override
    public void deleteRecycleById(Integer id) throws Exception {
        //获取到回收站中照片id
        Integer picture_id = recycleDao.selectRecyclePictureId(id);
        //删除回收站的记录
        recycleDao.deleteRecycleById(id);
        //删除照片中的记录
        recycleDao.deletePictureById(picture_id);
    }

}
