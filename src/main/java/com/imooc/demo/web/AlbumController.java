package com.imooc.demo.web;

import com.imooc.demo.bo.Album;
import com.imooc.demo.bo.User;
import com.imooc.demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
}
