package com.imooc.demo.service.impl;

import com.imooc.demo.bo.Admin;
import com.imooc.demo.dao.AdminDao;
import com.imooc.demo.dao.AlbumDao;
import com.imooc.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin selectAdmin(String name, String password) throws Exception {
        return adminDao.selectAdmin(name,password);
    }
}
