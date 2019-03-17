package com.imooc.demo.dao;

import com.imooc.demo.bo.AlbumAndUser;
import com.imooc.demo.bo.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void testUserSelectAll()throws Exception{
        List<User> userlist=userDao.UserSelectAll();
        userlist.get(0);
        System.out.println(userlist);
    }

}