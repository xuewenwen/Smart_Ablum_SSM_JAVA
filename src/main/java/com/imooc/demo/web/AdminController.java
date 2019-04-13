package com.imooc.demo.web;

import com.imooc.demo.bo.Admin;
import com.imooc.demo.service.AdminService;
import com.imooc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @RequestMapping("/admin/login")
    public String login(){
        return "/admin/login";
    }

    //管理员登陆
    @RequestMapping("/adminLogin")
    public String adminLogin(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String name = null;
        String password = null;
        name = request.getParameter("name");
        password = request.getParameter("password");
        Admin admin = adminService.selectAdmin(name,password);
        if(admin!=null){
            //若不等于空，将管理员名用session保存
            session.setAttribute("admin",name);
            return "redirect:/admin/show";
        }
        //报错去
        return "";
    }

    @RequestMapping("/admin/show")
    public String listUser(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Map<String,Object>> list=userService.userSelectAll();
        model.addAttribute("user",list);
        return "/admin/show";
    }

    @RequestMapping("/admin/selectById")
    public String selectUserById(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        Integer id = null;
        try {
            id= Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            return "";
        }
        Map<String,Object> map=userService.selectUserById(id);
        model.addAttribute("user1",map);
        return "/admin/searchResult";
    }


}
