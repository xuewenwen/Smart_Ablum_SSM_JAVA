package com.imooc.demo.service;

import com.imooc.demo.bo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminService {
    Admin selectAdmin(String name,String password)throws Exception;
}
