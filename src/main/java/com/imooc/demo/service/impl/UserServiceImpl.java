package com.imooc.demo.service.impl;

import com.imooc.demo.bo.AlbumAndUser;
import com.imooc.demo.bo.User;
import com.imooc.demo.dao.UserDao;
import com.imooc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<Map<String,Object>> userSelectAll() throws Exception {
        return userDao.userSelectAll();
    }

    @Override
    public Map<String, Object> selectUserById(Integer id) throws Exception {
        return userDao.selectUserById(id);
    }
    @Override
    public void SaveUser(User user)throws Exception{
        userDao.insertUser();
    }
}
