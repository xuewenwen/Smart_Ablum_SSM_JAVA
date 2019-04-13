package com.imooc.demo.web;

import com.imooc.demo.bo.Album;
import com.imooc.demo.bo.Picture;
import com.imooc.demo.bo.RecycleSite;
import com.imooc.demo.bo.User;
import com.imooc.demo.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class PictureController2 {
    @Autowired
    PictureService pictureService;

    @RequestMapping(value="/picture/search")
    //   @ResponseBody
    public String Search(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        return "/picture/search";
        //return model;
    }
    @RequestMapping("/picture/search/{tagName}")
    public String selectUrlByTagName(@PathVariable String tagName, ModelMap model, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        int id = user.getUserId();
        List<String> url=pictureService.selectUrlByTagName(tagName,id);
        model.addAttribute("tag",url);
        return "picture/searchResult";
    }

    //显示所有的照片
    @RequestMapping("/list/{albumId}")
    public String listPicture(@PathVariable String albumId, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.parseInt(albumId);
        model.addAttribute("id",id);
        return "/picture/show";
    }
    @RequestMapping("/picture/pictureList/{albumId}")
    public String list(@PathVariable String albumId, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.parseInt(albumId);
        List<Picture> picture = pictureService.listPicture(id);
        model.addAttribute("pic",picture);
        return "/picture/pictureList";
    }

    //将照片删除，并将其放到回收站中
    @RequestMapping("/picture/delete")
    public void delete(@RequestBody String str, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String[] arr = str.split(",");
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        int id = user.getUserId();
        for(int i=0;i<arr.length;i++){
            int j =Integer.parseInt(arr[i]);
            RecycleSite recycleSite = new RecycleSite();
            recycleSite.setUserId(id);
            recycleSite.setPictureId(j);
            recycleSite.setPictureDeleteTime(new Date());
            pictureService.deletePicture(j,recycleSite);
        }
    }

}
