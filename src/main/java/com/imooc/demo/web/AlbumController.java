package com.imooc.demo.web;

import com.github.pagehelper.PageHelper;
import com.imooc.demo.bo.Album;
import com.imooc.demo.bo.User;
import com.imooc.demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/insert")
    public String insert(ModelMap model, HttpServletRequest request, HttpServletResponse response )throws Exception {
        return "insert";
    }

    @RequestMapping("/list")
    public String list(ModelMap model, HttpServletRequest request, HttpServletResponse response )throws Exception {
        return "list";
    }
    @RequestMapping("/albumList")
    public String listAlbum(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        int id = user.getUserId();
       // PageHelper.startPage()

        List<Album> list = albumService.selectAlbumByUserId(id);
        model.addAttribute("album",list);
        return "/albumList";
    }
    @RequestMapping(value = "/album/create",method = RequestMethod.GET)
    public  String tog(){
        return "/album/create";
    }


    @RequestMapping(value="/album/create", method = RequestMethod.POST)
    @ResponseBody
    public Map insertAlbum(
                                             HttpSession httpSession,
                                             HttpServletRequest request
                                             ,@RequestParam(value = "file_data") MultipartFile file
                                            ,@RequestParam(value = "albumName") String albumName
                                            ,@RequestParam(value = "albumDescription") String albumDescription)throws Exception
    {

        Album album = new Album();
        Map<String, Object> result = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        /*User user=(User)session.getAttribute("user");
        int id = user.getUserId();*/
        int id = 1;
        //int albumId = (int)session.getAttribute("album");
        int albumId = 1;

        String fileName = "";//files[0].getSize();
        String msg = "";
        String fileType = "";
        String realFileName;
        if (file != null) {
            String fileName2 = file.getOriginalFilename();
            String picName = fileName2;
            String extName = "";

            int pos = fileName2.lastIndexOf(".");

            if (pos > -1) {
                extName = fileName2.substring(pos);
                picName = fileName2.substring(0, pos);
            }

            String picPath = "/images/"+"cover"+"/" + id + "/";

            String picFileName = UUID.randomUUID().toString() + extName;

            String basePath = this.getClass().getResource("/").getPath() + "/static/";

            //文件路径
            String filePath = basePath + picPath;

            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            //存储的图片路径
            String picturePath = basePath + picPath + picFileName;
            //数据库的访问路径
            fileName = picPath + picFileName;
            album.setAlbumCover(fileName);
            File dest = new File(picturePath);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
                result.put("msg", "IOException e");
                return result;
            }

        }
        album.setAlbumId(1);//从session中获取
        album.setAlbumCreateTime(new Date());
        album.setAlbumName(albumName);
        album.setAlbumDescription(albumDescription);
        album.setUserId(1);
        //
        albumService.insertAlbum(album);


        result.put("code", 0);
        result.put("msg", "创建成功！");
        return result;
    }
}
