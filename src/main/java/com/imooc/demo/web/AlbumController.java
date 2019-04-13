package com.imooc.demo.web;

import com.imooc.demo.bo.Album;
import com.imooc.demo.bo.User;
import com.imooc.demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/list")
    public String list(ModelMap model, HttpServletRequest request, HttpServletResponse response )throws Exception {
        return "list";
    }
    @RequestMapping("/albumList")
    public String listAlbum(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        int id = user.getUserId();
        List<Album> list = albumService.selectAlbumByUserId(id);
        model.addAttribute("album",list);
        return "/albumList";
    }
    @RequestMapping(value = "/album/create",method = RequestMethod.GET)
    public  String tog(){
        return "/album/create";
    }


    @RequestMapping(value="/album/create", method = RequestMethod.POST)
    public String insertAlbum(@ModelAttribute Album album, Model model, HttpSession httpSession,HttpServletRequest request)throws Exception
    {
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        Album record = new Album();
        record.setUserId(user.getUserId());
        record.setAlbumCreateTime(new Date());
        record.setAlbumDescribtion(album.getAlbumDescribtion());
        record.setAlbumName(album.getAlbumName());
        albumService.insertAlbum(record);
        return "/album/create";
    }





}
