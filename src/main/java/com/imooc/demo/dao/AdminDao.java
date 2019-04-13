package com.imooc.demo.dao;

import com.imooc.demo.bo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminDao {
    Admin selectAdmin(@Param("name")String name,@Param("password")String password)throws Exception;
}
