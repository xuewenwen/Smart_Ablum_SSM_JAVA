package com.imooc.demo.dao;

import com.imooc.demo.bo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    /**
     * 列出用户列表
     *
     * @return areaList
     */
    public List<User> UserSelectAll() throws Exception;
    /**
     * 用ID找具体用户
     *
     * @return user
     */
    User queryUserById(String userID);
    /**
     * 根据用户名找到具体用户
     *
     * @return user
     */
    User queryUserByName(String userName);

    int insertUser();
}
