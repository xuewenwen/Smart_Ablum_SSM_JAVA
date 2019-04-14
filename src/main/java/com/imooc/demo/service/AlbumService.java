package com.imooc.demo.service;

import com.imooc.demo.bo.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> selectAlbumByUserId(Integer id) throws Exception;
    public int insertAlbum(Album album) throws Exception;
    public String selectAlbumName(Integer id);
}
