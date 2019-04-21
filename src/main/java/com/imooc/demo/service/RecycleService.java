package com.imooc.demo.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RecycleService {
    public List<Map<String,Object>> selectAllPicture(Integer id) throws Exception;

    //将照片移回原来相册
    public void updatePictureStatus(Integer id) throws Exception;
    public Map<String,Object> selectPicAlbum(Integer id);

    //彻底删除
    public void deleteRecycleById(Integer id,Integer userId) throws Exception;

    //删除时间大于30天的照片
    public void deletePic30day();
}
