package com.imooc.demo.service;

import com.imooc.demo.bo.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumService {
    public List<Album> selectAlbumByUserId(@Param("id") Integer id) throws Exception;
    public int insertAlbum(Album album) throws Exception;
}
