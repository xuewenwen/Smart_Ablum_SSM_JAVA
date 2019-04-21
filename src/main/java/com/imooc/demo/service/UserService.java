package com.imooc.demo.service;

import com.imooc.demo.bo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserService {

    public void SaveUser(User user)throws Exception;
    public List<Map<String,Object>> userSelectAll()throws Exception;
    public Map<String,Object> selectUserById(Integer id) throws Exception;
    public void sendSimpleMail(String to,String title,String content) throws Exception;
    public void activate(String name);
    public boolean checkAccountByEmail(String email);
    public void updateCheckCodeByEmail(String email,int userCheckCode);
    public void updateUserInfoByEmail(String userEmail,String userName);
    public void updateUserPasswordByEmail(String userEmail,String userPassword);
    public void updateUserLastLoginTime(String userEmail, Date userLastLoginTime);

    public void updateSize(Long size,Integer id);

    public void updateMinusSize(Long size,Integer id);

    public User selectByUserId(Integer id);
}
