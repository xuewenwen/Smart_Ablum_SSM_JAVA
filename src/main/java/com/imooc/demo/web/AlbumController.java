package com.imooc.demo.web;

import com.imooc.demo.bo.Album;
import com.imooc.demo.bo.Picture;
import com.imooc.demo.bo.User;
import com.imooc.demo.service.AlbumService;
import com.imooc.demo.service.PictureService;
import com.imooc.demo.utils.ImagUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
@EnableAutoConfiguration
@Controller
public class AlbumController {
    @Autowired
    private PictureService pictureService;

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/srcAdd")
    public String srcAdd(){
        return "srcAdd";
    }


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

    @RequestMapping("/down")
    public String download(){
        return "download";
    }


    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public Map ocr(@RequestParam(value = "file_data") MultipartFile file, HttpServletRequest request){
        String fileName = "";//files[0].getSize();
        String msg = "";
        String fileType = "";
        String realFileName;
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        int id = user.getUserId();
        int albumId = (int)session.getAttribute("album");
        Map<String, Object> result = new HashMap<String, Object>();
        /*HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        int albumId = (int)session.getAttribute("album");
        int userId = user.getUserId();*/


        if (!file.isEmpty()) {
            String fileName2 = file.getOriginalFilename();
            String picName = fileName2;
            String extName = "";

            int pos = fileName2.lastIndexOf(".");

            if (pos > -1) {
                extName = fileName2.substring(pos);
                picName = fileName2.substring(0, pos);
            }

            String picPath = "/images/upload/" + id + "/";

            //存放缩略图的路径
            String thumbnailPath = "/images/upload/" + id + "/thumbnail" + "/";

            String picFileName = UUID.randomUUID().toString() + extName;

            String basePath = this.getClass().getResource("/").getPath() + "/static/";

            //文件路径
            String filePath = basePath + picPath;
            //缩略图文件的路径
            String thumbnailFilePath = basePath + thumbnailPath;

            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            //创建缩略图文件夹
            File thumbnailFile = new File(thumbnailFilePath);
            if (!thumbnailFile.exists()) {
                thumbnailFile.mkdirs();
            }
            //存储的图片路径
            String picturePath = basePath + picPath + picFileName;

            //将该照片存储到thumbnail路径下，缩略图的工具类会将其覆盖重命名
            String thumbnailPicturePath = basePath + thumbnailPath + picFileName;

            //数据库的访问路径
            fileName = picPath + picFileName;
            File dest = new File(picturePath);
            File pictureThumbnail = new File(thumbnailPicturePath);
            String thumbnailPicPath = "";
            try {
                //保存该图片
                file.transferTo(dest);
            } catch (IOException e) {
                 e.printStackTrace();
                   result.put("msg", "FileUploadException e");
                   return result;
            }
        }



        albumService.modifyURL(fileName,albumId,id);
        result.put("code",0);
        result.put("msg","成功");
        return result;
    }



    @RequestMapping(value = "/uploadCover", method = RequestMethod.POST)
    @ResponseBody
    public Map ocr(@RequestParam(value = "file_data") MultipartFile file, HttpServletRequest request
            ,@RequestParam(value = "albumName") String albumName
            ,@RequestParam(value = "albumDescription") String albumDescription
                ) throws Throwable {
        Map<String, Object> result = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        int id = user.getUserId();
//        int albumId = (int)session.getAttribute("album");
        int userId = ((User)session.getAttribute("user")).getUserId();

        Album album = new Album();
        boolean upFlag = true;

        List<Album> albums = albumService.selectAlbumByUserId(userId);
        boolean flag = false;
        for (Album alb :
             albums) {
            if(alb.getAlbumName().equals(albumName)){
                flag = true;break;
            }
        }
        if(flag==true) {
            result.put("msg", "这个相册已经存在了！");
            return result;
        }


        String fileName = "";//files[0].getSize();
        String msg = "";
        String fileType = "";
        String realFileName;
        String pretermission = "/images/upload/pretermission/1.png";

        if (!file.isEmpty()) {
            String fileName2 = file.getOriginalFilename();
            String picName = fileName2;
            String extName = "";

            int pos = fileName2.lastIndexOf(".");

            if (pos > -1) {
                extName = fileName2.substring(pos);
                picName = fileName2.substring(0, pos);
            }

            String picPath = "/images/upload/" + id + "/";

            //存放缩略图的路径
            String thumbnailPath = "/images/upload/" + id + "/thumbnail" + "/";

            String picFileName = UUID.randomUUID().toString() + extName;

            String basePath = this.getClass().getResource("/").getPath() + "/static/";

            //文件路径
            String filePath = basePath + picPath;
            //缩略图文件的路径
            String thumbnailFilePath = basePath + thumbnailPath;

            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            //创建缩略图文件夹
            File thumbnailFile = new File(thumbnailFilePath);
            if (!thumbnailFile.exists()) {
                thumbnailFile.mkdirs();
            }
            //存储的图片路径
            String picturePath = basePath + picPath + picFileName;

            //将该照片存储到thumbnail路径下，缩略图的工具类会将其覆盖重命名
            String thumbnailPicturePath = basePath + thumbnailPath + picFileName;

            //数据库的访问路径
            fileName = picPath + picFileName;
            File dest = new File(picturePath);
            File pictureThumbnail = new File(thumbnailPicturePath);
            String thumbnailPicPath = "";
            try {
                //保存该图片
                file.transferTo(dest);
            } catch (IOException e) {
                // e.printStackTrace();
                //   result.put("msg", "FileUploadException e");
                //   return result;
                upFlag = false;
            }
        }else
        {
            fileName = pretermission;
        }



            album.setAlbumDescription(albumDescription);
            album.setAlbumCreateTime(new Date());
            album.setUserId(userId);
            album.setAlbumName(albumName);
            album.setAlbumNumOfPic(0);
            //pretermission
            album.setAlbumCover(fileName);

            try{
                albumService.insertAlbum(album);
            }catch (SQLException e){
                e.printStackTrace();
                result.put("msg", "数据库错误！");
            }


//            //保存tag值,使用百度ai
//            tagService.Ai(picturePath,pictureId);
            //保存百度ai中的tag值，使用线程池的方法
            //    threadExecute.Execute(picturePath,pictureId);
            result.put("code", 0);
            if(upFlag == false)
                result.put("msg", "确定不需要照片吗！");
            result.put("msg", "创建成功！");
            return result;

        /*else {
            result.put("msg", "Unable to upload. File is empty.");
            return result;
        }*/

    }


}
