package com.imooc.demo.service;

import com.imooc.demo.bo.AlbumAndUser;
import com.imooc.demo.bo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {
    public List<Map<String,Object>> userSelectAll()throws Exception;

    public Map<String,Object> selectUserById(Integer id) throws Exception;

}
