package com.imooc.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Password {
    @RequestMapping(value = "/retrievepassword",method = RequestMethod.GET)
    public String index(){
        return "retrievepassword";
    }
}