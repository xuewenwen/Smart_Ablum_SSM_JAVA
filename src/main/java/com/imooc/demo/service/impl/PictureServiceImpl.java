package com.imooc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.imooc.demo.bo.Album;
import com.imooc.demo.bo.Picture;
import com.imooc.demo.bo.RecycleSite;
import com.imooc.demo.bo.User;
import com.imooc.demo.dao.AlbumDao;
import com.imooc.demo.dao.PictureDao;
import com.imooc.demo.dao.UserDao;
import com.imooc.demo.service.PictureService;
import com.imooc.demo.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {

    @Autowired
    PictureDao pictureDao;
    @Autowired
    UserDao userDao;
    @Autowired
    AlbumDao albumDao;


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
        //PageBean<Picture> pageData = new PageBean<>(currentPage, pageSize, count);
        PageBean<Picture> pageData = new PageBean<>(currentPage, pageSize, count);
        //总页数
        int total = pageData.getTotalPage();
        //第一页
        if(currentPage<1){
            //currentPage = total;
            pageData = new PageBean<>(total, pageSize, count);
        }
        //最后一页
        if(currentPage>total){
           // currentPage=1;
            pageData = new PageBean<>(1, pageSize, count);
        }
        pageData.setItems(picturesList);
        return pageData.getItems();
    }

    @Override
    public Long selectPicSize(Integer id) {
        return pictureDao.selectPicSize(id);
    }

    @Override
    public void updateMessageByJob() throws Exception {
        //查找所有的用户信息
        List<User> list = userDao.selectAll();
        for(User user:list){
            int userId = user.getUserId();
            //通过用户id查找该用户所有的相册信息
            List<Album> albumList = albumDao.selectByUserId(userId);
            //用来做容量统计的
            Long size = 0L;
            for(Album album:albumList){
                int albumId = album.getAlbumId();
                //数据库中存储的原有的数量
                int albumCount = album.getAlbumNumOfPic();
                if(albumCount==0){
                    continue;
                }
                //统计所有的照片数
                int count = pictureDao.selectPicNumByAlbumId(albumId);

                //判断两者是否相同
                if(count != albumCount){
                    //不同，则替换
                    albumDao.updateAlbumNum(count,albumId);
                }
                //相同，则继续判断容量是否相同,这边先做统计
                    Long albumSize = pictureDao.selectPicSizeByAlbumId(albumId);
                    size = size + albumSize;
            }
            //用户表中原有的容量数
            Long userSize = user.getUserSize();
            //若不同，则替换
            if(userSize!=size){
                userDao.updateSizeByJob(size,userId);
            }

        }
    }


}
