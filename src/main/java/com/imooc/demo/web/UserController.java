package com.imooc.demo.web;

import com.imooc.demo.bo.User;
import com.imooc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
    public int Register(@RequestParam("userName")String userName,@RequestParam("userPassword")String userPassword,@RequestParam("userEmail")String userEmail) throws Exception {

        int userCode = new Random().nextInt(899999) + 100000;
        int userStatus=0;
        int userSize=0;
        Date userRegisterTime=new Date();
        Date userLastLoginTime=new Date();
        User user=new User(userName,userPassword,userEmail,userStatus,userSize,userRegisterTime,userLastLoginTime,userCode);

        String message="您的注册验证码为："+userCode;
        userService.sendSimpleMail(userEmail,"注册验证码",message);
        userService.SaveUser(user);

        return userCode;
}

}
