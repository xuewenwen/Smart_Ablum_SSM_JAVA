package com.imooc.demo.web;

import com.imooc.demo.bo.User;
import com.imooc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

   public UserController(UserService userService) {
       this.userService=userService;
   }


    @RequestMapping(value = "/getCheckCode",method = RequestMethod.GET)
    @ResponseBody
//该注解用于读取Request请求的body部分数据，
// 使用系统默认配置的HttpMessageConverter进行解析，
// 然后把相应的数据绑定到要返回的对象上；
    public String getCheckCode( String email){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        try {
            userService.sendSimpleMail(email, "注册验证码", message);
        }catch (Exception e){
            return "";
        }
        return checkCode;
    }
    @RequestMapping(value = "/activate",method = RequestMethod.GET)
    public int Activate(@RequestParam("userName") String n)throws Exception{
       userService.activate(n);
        return 0;
    }



    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public int Register (@RequestParam("userName")String userName,@RequestParam("userPassword")String userPassword,@RequestParam("userEmail")String userEmail) throws Exception {

        int userCode = new Random().nextInt(899999) + 100000;
        int userStatus=0;
        Long userSize=0L;
        Date userRegisterTime=new Date();
        Date userLastLoginTime=new Date();
        int errorCode=2;
        boolean check=userService.checkAccountByEmail(userEmail);
        if (!check){
            //如果账号不存在，则可以执行注册
        User user=new User(userName,userPassword,userEmail,userStatus,userSize,userRegisterTime,userLastLoginTime,userCode);

        String message="您的注册验证码为："+userCode;
        userService.sendSimpleMail(userEmail,"注册验证码",message);
        userService.SaveUser(user);

        return userCode;
        }
        else {
            return errorCode;
        }
   }
   @RequestMapping(value = "/SendCheckCode" ,method = RequestMethod.POST)
    public int changePassword(@RequestParam("userEmail") String userEmail) throws Exception {
       int userCode = new Random().nextInt(899999) + 100000;
       int errorCode=2;
       boolean check=userService.checkAccountByEmail(userEmail);
       if (!check){//如果账号存在才能找回密码
       userService.updateCheckCodeByEmail(userEmail,userCode);
       String message="您的注册验证码为："+userCode;
       userService.sendSimpleMail(userEmail,"注册验证码",message);
       //发送验证码成功
       return userCode;}
       return errorCode;
   }
   @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public void updatePassword(@RequestParam("userEmail") String userEmail,@RequestParam("userPassword") String userPassword){
       userService.updateUserPasswordByEmail(userEmail,userPassword);
   }
   @RequestMapping(value = "/updateUserInformation",method = RequestMethod.POST)
    public void updateUserInformation(@RequestParam("userEmail")String userEmail,@RequestParam("userName") String userName){
       userService.updateUserInfoByEmail(userEmail,userName);
   }

   @RequestMapping("/exit")
    public String exit(HttpSession session){
       session.removeAttribute("user");
       return "redirect:/login";
   }

}