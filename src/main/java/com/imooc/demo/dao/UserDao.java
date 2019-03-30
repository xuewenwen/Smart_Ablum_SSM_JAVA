package com.imooc.demo.dao;

import com.imooc.demo.bo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    public List<Map<String,Object>> userSelectAll() throws Exception;

    public Map<String,Object> selectUserById(Integer id) throws Exception;

    User selectUserByName(String userID);

    User selectUserByEmail(String userEmail);
    void UpdateUser(User user);//更新用户


//    int insertUser();
}
