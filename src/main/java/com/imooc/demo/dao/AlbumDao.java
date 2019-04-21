package com.imooc.demo.dao;

import com.imooc.demo.bo.Album;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AlbumDao {
    public List<Album> selectAlbumByUserId(@Param("id") Integer id) throws Exception;

   public int insertAlbum(Album album);

   public String selectAlbumName(@Param("id")Integer id);

   public void updateNum(@Param("id")Integer id);

   public void updateMinusNum(@Param("id")Integer id);

   public void  modifyURL(@Param("albumCover") String albumCover, @Param("albumId")Integer albumId,@Param("userId")Integer userId);
}
