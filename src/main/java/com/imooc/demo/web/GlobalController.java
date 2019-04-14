package com.imooc.demo.web;


import com.imooc.demo.bo.User;
import com.imooc.demo.service.GlobalService;
import com.imooc.demo.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
@Controller("globalController")
public class GlobalController {
   @Autowired
    private GlobalService globalService;
   @Autowired
   private Md5Utils md5Utils;
    @RequestMapping("to_login")
    public String toLogin(){
               return "login";
    }
// @RequestParam 表示注明用户提交过来的信息
    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String userEmail, @RequestParam String userpassword) {
        String p=Md5Utils.getStrrMD5(userpassword);
        User user = globalService.login(userEmail, p);
        if (user == null) {
            return "redirect:login";
        }
        session.setAttribute("user", user);
        return "redirect:list";
    }

//    @RequestMapping("/list")
//    public  String intoHome(){
//
//            return "list";
//
//    }

}
