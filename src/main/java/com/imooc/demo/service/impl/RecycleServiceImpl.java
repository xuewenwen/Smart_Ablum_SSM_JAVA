package com.imooc.demo.service.impl;

import com.imooc.demo.bo.RecycleSite;
import com.imooc.demo.dao.PictureDao;
import com.imooc.demo.dao.RecycleDao;
import com.imooc.demo.dao.UserDao;
import com.imooc.demo.service.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class RecycleServiceImpl implements RecycleService {
    @Autowired
    private RecycleDao recycleDao;
    @Autowired
    private PictureDao pictureDao;
    @Autowired
    private UserDao userDao;
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
    public Map<String,Object> selectPicAlbum(Integer id) {
        return recycleDao.selectPicAlbum(id);
    }

    @Override
    public void deleteRecycleById(Integer id,Integer userId) throws Exception {
        //获取到回收站中照片id
        Integer picture_id = recycleDao.selectRecyclePictureId(id);
        Long size = pictureDao.selectPicSize(picture_id);
        //更新用户容量
        userDao.updateMinusSize(size,userId);
        //删除回收站的记录
        recycleDao.deleteRecycleById(id);
        //删除照片中的记录
        recycleDao.deletePictureById(picture_id);
    }

    @Override
    public void deletePic30day() {
        //查找所有的回收站大于30天的照片
        List<RecycleSite> list = recycleDao.selectDay();
        for(RecycleSite recycleSite:list){
            int recycleId = recycleSite.getRecycleId();
            int userId = recycleSite.getUserId();
            try {
                deleteRecycleById(recycleId,userId);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
