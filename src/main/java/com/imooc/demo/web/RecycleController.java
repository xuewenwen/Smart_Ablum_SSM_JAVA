package com.imooc.demo.web;

import com.imooc.demo.bo.User;
import com.imooc.demo.service.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class RecycleController {
    @Autowired
    private RecycleService recycleService;

    @RequestMapping("/recycle/recycle")
    public String showAllRecyclePicture(ModelMap model, HttpServletRequest request, HttpServletResponse response )throws Exception {
        /*HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        int id = user.getUserId();
        List<Map<String,Object>> list = recycleService.selectAllPicture(id);
        model.addAttribute("recycle",list);*/
        return "/recycle/recycle";
    }

    @RequestMapping("/recycle/list")
    public String list(ModelMap model, HttpServletRequest request, HttpServletResponse response )throws Exception {
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        int id = user.getUserId();
        List<Map<String,Object>> list = recycleService.selectAllPicture(id);
        model.addAttribute("recycle",list);
        return "/recycle/list";
    }

    //将回收站的照片移回到原来的相册中
    @RequestMapping("/recycle/remove")
    public void removePicture(@RequestBody String str, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        String[] arr = str.split(",");
        for(int i=0;i<arr.length;i++){
            int j =Integer.parseInt(arr[i]);
            recycleService.updatePictureStatus(j);
        }
    }
    //将回收站的照片彻底删除，同时删除照片表里面的记录
    @RequestMapping("/recycle/removePicture")
    public void removePictureCompletely(@RequestBody String str, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String[] arr = str.split(",");
        for(int i=0;i<arr.length;i++){
            int j =Integer.parseInt(arr[i]);
            recycleService.deleteRecycleById(j);
        }
    }
}
