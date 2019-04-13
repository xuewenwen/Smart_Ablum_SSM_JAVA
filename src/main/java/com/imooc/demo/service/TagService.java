package com.imooc.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface TagService {
    //将tag标签进行插入
    public void insertTag(String name,Integer id) throws Exception;

    public void Ai(String path, Integer id);
}
