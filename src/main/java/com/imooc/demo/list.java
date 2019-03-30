package com.imooc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class list {
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String index(){
        return "list";
    }
}