package com.imooc.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class login {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String index(){
        return "login";
    }

    @RequestMapping("/retrievepassword")
    public String retrievepassword(){
        return "/retrievepassword";
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login";
    }
}