package com.imooc.demo.service;

import com.imooc.demo.bo.User;

public interface GlobalService {
    User login(String userEmail , String userpassword);

    void  changepassword(User user);

}
