package com.imooc.demo.dao;

import com.imooc.demo.bo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    public List<Map<String,Object>> userSelectAll() throws Exception;
    public Map<String,Object> selectUserById(Integer id) throws Exception;
    User selectUserByName(String userName);
    User queryUserByName(String userName);//返回一个User对象
    User queryUserByEmail(String userEmail);//返回一个User对象
    void insertUser(User user);//保存新注册的用户的信息,状态保存为0
    void updateUser(User user);//更新用户信息：用户名，密码，邮箱
    void activateUserByName(String userName);//激活状态为1
    void banUserById(int userID);//封禁，状态为2
}
