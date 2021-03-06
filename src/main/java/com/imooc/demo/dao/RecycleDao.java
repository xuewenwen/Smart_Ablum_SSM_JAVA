package com.imooc.demo.dao;

import com.imooc.demo.bo.RecycleSite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecycleDao {
    public List<Map<String,Object>> selectAllPicture(@Param("id") Integer id) throws Exception;

    public void updatePictureStatus(@Param("id") Integer id) throws Exception;

    public void deleteRecycleById(@Param("id") Integer id) throws Exception;

    public Integer selectRecyclePictureId(@Param("id") Integer id) throws Exception;

    public void deletePictureById(@Param("id") Integer id) throws Exception;

    public Map<String,Object> selectPicAlbum(@Param("id") Integer id);

    public List<RecycleSite> selectDay();
}
