package com.imooc.demo.dao;

import com.imooc.demo.bo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    public List<User> UserSelectAll() throws Exception;
}
