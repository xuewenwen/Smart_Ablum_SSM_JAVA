package com.imooc.demo.web;


import com.imooc.demo.bo.User;
import com.imooc.demo.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
@Controller("globalController")
public class GlobalController {
   @Autowired
    private GlobalService globalService;
    @RequestMapping("to_login")
    public String toLogin(){
               return "login";
    }
// @RequestParam 表示注明用户提交过来的信息
    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String userpassword) {
        User user = globalService.login(username, userpassword);
        if (user == null) {
            return "redirect:login";
        }
        session.setAttribute("user", user);
        return "redirect:list";
    }

    @RequestMapping("/list")
    public  String intoHome(){

            return "list";

    }

}
