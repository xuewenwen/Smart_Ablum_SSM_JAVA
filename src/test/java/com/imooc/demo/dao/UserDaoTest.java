package com.imooc.demo.dao;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void testUserSelectAll()throws Exception{
        List<Map<String,Object>> userlist=userDao.userSelectAll();
        System.out.println(userlist);
    }
    @Test
    public void testselectUserById()throws Exception{
        Map<String,Object> userlist=userDao.selectUserById(1);
        System.out.println(userlist);
    }
//    @Test
//    public void test(){
//        User user = userDao.queryUserByEmail("519899388@qq.com");
//        System.out.println(user);
//    }

}