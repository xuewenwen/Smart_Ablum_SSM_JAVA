package com.imooc.demo.service.impl;

import com.imooc.demo.bo.User;
import com.imooc.demo.dao.UserDao;
import com.imooc.demo.service.GlobalService;
import com.imooc.demo.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("GlobalService")
public class GloBalImp implements GlobalService {
    @Autowired
    public UserDao userDao;

    @Override
    public User login(String userEmail, String userpassword) {
        User user = userDao.queryUserByEmail(userEmail);
        if (user != null && user.getUserPassword().equals(userpassword)) {
            return user;
        }
        else {
            return null;
        }
    }

    @Override
    public void changepassword(User user) {
//                userDao.UpdateUser(user);
    }
}
