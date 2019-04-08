package com.imooc.demo.service;

import com.imooc.demo.bo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public void SaveUser(User user)throws Exception;
    public List<Map<String,Object>> userSelectAll()throws Exception;
    public Map<String,Object> selectUserById(Integer id) throws Exception;
    public void sendSimpleMail(String to,String title,String content) throws Exception;
//    public void Register(String username, String password, String email);
//    public void processRegister(String email);
    public void activate(String name);
}
