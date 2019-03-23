package com.imooc.demo.service.impl;

import com.imooc.demo.bo.User;
import com.imooc.demo.dao.UserDao;
import com.imooc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> UserSelectAll() throws Exception {
        return userDao.UserSelectAll();
    }
    @Override
    public void SaveUser(User user)throws Exception{
        userDao.insertUser();
    }
}
