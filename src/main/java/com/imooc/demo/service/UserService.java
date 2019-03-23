package com.imooc.demo.service;

import com.imooc.demo.bo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserService {
    public List<User> UserSelectAll()throws Exception;
    public void SaveUser()throws Exception;
}
