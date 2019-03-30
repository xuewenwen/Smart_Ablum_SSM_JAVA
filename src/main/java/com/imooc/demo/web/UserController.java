package com.imooc.demo.web;

import com.imooc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/admin/show")
    public String listUser(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Map<String,Object>> list=userService.userSelectAll();
        model.addAttribute("user",list);
       return "/admin/show";
    }

//    @RequestMapping(value="/admin/search")
//    //   @ResponseBody
//    public String Search(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
//        return "/admin/search";
//        //return model;
//    }

    @RequestMapping("/admin/selectById")
    public String selectUserById(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        Integer id = null;
        try {
            id= Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            return "";
        }
        Map<String,Object> map=userService.selectUserById(id);
        model.addAttribute("user",map);
        return "/admin/searchResult";
    }
}
