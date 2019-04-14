package com.imooc.demo.web;

import com.imooc.demo.bo.Album;
import com.imooc.demo.bo.Picture;
import com.imooc.demo.bo.RecycleSite;
import com.imooc.demo.bo.User;
import com.imooc.demo.service.AlbumService;
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
    @Autowired
    AlbumService albumService;

    @RequestMapping(value="/picture/search")
    public String Search(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        return "/picture/search";
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
        String albumName = albumService.selectAlbumName(id);
        model.addAttribute("name",albumName);
        model.addAttribute("id",id);
        return "/picture/show";
    }
    @RequestMapping("/picture/pictureList/{albumId}")
    public String list(@PathVariable String albumId, ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
        Integer id = Integer.parseInt(albumId);
        session.setAttribute("album",id);
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
    @RequestMapping("/lisS")
    public String a(){
        return "/lisS";
    }

}
