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

    @RequestMapping("/user/show")
 //   @ResponseBody
    public ModelMap listUser(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Map<String,Object>> list=userService.userSelectAll();
        model.addAttribute("user",list);
       return model;
     // return "user/show";
    }

    @RequestMapping(value="/user/search")
    //   @ResponseBody
    public String Search(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        return "/user/search";
        //return model;
    }

    @RequestMapping("/user/selectById")
    //   @ResponseBody
    public String selectUserById(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        //@RequestParam(value = "id") Integer id,
        Integer id = null;
        try {
            id= Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            return "";
        }
        Map<String,Object> map=userService.selectUserById(id);
        model.addAttribute("user",map);
        return "/user/searchResult";
    }
}
