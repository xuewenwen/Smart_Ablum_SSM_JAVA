package com.imooc.demo.service;

import com.imooc.demo.bo.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumService {
    public List<Album> selectAlbumByUserId(Integer id) throws Exception;
    public int insertAlbum(Album album) throws Exception;
    public String selectAlbumName(Integer id);
    //修改相册数量 加
    public void updateAlbumNum(Integer id);
    //修改相册数量 减
    public void updateMinusNum(Integer id);
}
