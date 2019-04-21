package com.imooc.demo.service.impl;

import com.imooc.demo.bo.User;
import com.imooc.demo.dao.UserDao;
import com.imooc.demo.service.UserService;
import com.imooc.demo.utils.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Value("${spring.mail.username}") private String from;

    @Autowired
    private JavaMailSender mailSender;//发送邮件对象

    @Autowired
    private HttpServletRequest request;


    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public List<Map<String,Object>> userSelectAll() throws Exception {
        return userDao.userSelectAll();
    }

    @Override
    public Map<String, Object> selectUserById(Integer id) throws Exception {
        return userDao.selectUserById(id);
    }
//    @Override
//    public User queryUserByName(String name){
//        return userDao.selectUserByName(name);
//    }
    @Override
    public void sendSimpleMail(String to,String title,String content){

        SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(title);
            message.setText(content);
            mailSender.send(message);
            logger.info("邮件发送成功");
    }
    @Override
    public void activate(String name){
            userDao.activateUserByName(name);
    }
    @Override
    public void SaveUser(User user)throws Exception{
            String psw=user.getUserPassword();
            String saltPsw=Md5Utils.getStrrMD5(psw);//密码经过md5加密后再保存进数据库
            user.setUserPassword(saltPsw);
            userDao.insertUser(user);
    }
    @Override
    public boolean checkAccountByEmail(String email){
        User user = userDao.queryUserByEmail(email);
        if(user!=null){
            return true;
        }
        else{
            return false;}
}

    @Override
    public void updateCheckCodeByEmail(String email,int userCheckCode){
        User user=userDao.queryUserByEmail(email);
        user.setUserCode(userCheckCode);
    };

    @Override
    public void updateUserPasswordByEmail(String userEmail,String userPassword){
        User user=userDao.queryUserByEmail(userEmail);//得到了要修改密码的那个对象
        String psw=Md5Utils.getStrrMD5(userPassword);//加密后保存在数据库
        user.setUserPassword(psw);
        userDao.updateUser(user);
    };
     @Override
     public void updateUserInfoByEmail(String userEmail,String userName){
         User user=userDao.queryUserByEmail(userEmail);//得到了要修改名字的那个对象
         user.setUserName(userName);
         userDao.updateUser(user);
     }
     @Override
     public void updateUserLastLoginTime(String userEmail, Date userLastLoginTime){
         User user=userDao.queryUserByEmail(userEmail);
         user.setUserLastLoginTime(userLastLoginTime);
         userDao.updateUser(user);
     }

    @Override
    public void updateSize(Long size, Integer id) {
        userDao.updateSize(size,id);
    }

    @Override
    public void updateMinusSize(Long size, Integer id) {
        userDao.updateMinusSize(size,id);
    }

    @Override
    public User selectByUserId(Integer id) {
        return userDao.selectByUserId(id);
    }
}
