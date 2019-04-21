package com.imooc.demo.service.impl;

import com.imooc.demo.bo.Album;
import com.imooc.demo.dao.AlbumDao;
import com.imooc.demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Override
    public List<Album> selectAlbumByUserId(Integer id) throws Exception {
        return albumDao.selectAlbumByUserId(id);
    }

    @Override
    public  int insertAlbum(Album album) throws Exception{
        return albumDao.insertAlbum(album);
    }

    @Override
    public String selectAlbumName(Integer id) {
        return albumDao.selectAlbumName(id);
    }

    @Override
    public void updateAlbumNum(Integer id) {
        albumDao.updateNum(id);
    }

    @Override
    public void updateMinusNum(Integer id) {
        albumDao.updateMinusNum(id);
    }

}
