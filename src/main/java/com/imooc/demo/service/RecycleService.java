package com.imooc.demo.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RecycleService {
    public List<Map<String,Object>> selectAllPicture(Integer id) throws Exception;

    //将照片移回原来相册
    public void updatePictureStatus(Integer id) throws Exception;

    //彻底删除
    public void deleteRecycleById(Integer id) throws Exception;
}
