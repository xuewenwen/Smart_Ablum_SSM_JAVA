package com.imooc.demo.service;

import com.imooc.demo.bo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public void SaveUser(User user)throws Exception;
    public List<Map<String,Object>> userSelectAll()throws Exception;
    public Map<String,Object> selectUserById(Integer id) throws Exception;
    public void sendSimpleMail(String to,String title,String content) throws Exception;
    public void activate(String name);
    public boolean checkAccountByEmail(String email);

}
