package com.imooc.demo.web;

import com.imooc.demo.bo.Picture;
import com.imooc.demo.bo.User;
import com.imooc.demo.service.PictureService;
import com.imooc.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;
    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/ocr", method = RequestMethod.POST)
    @ResponseBody
    public Map ocr(@RequestParam(value = "file_data") MultipartFile file,HttpServletRequest request) throws Throwable {
        Map<String, Object> result = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        int id = user.getUserId();
        int albumId = (int)session.getAttribute("album");
        String fileName = "";//files[0].getSize();
        String msg = "";
        String fileType = "";
        String realFileName;
        if (file != null) {
            String fileName2 = file.getOriginalFilename();
            String picName=fileName2;
            String extName="";

            int pos = fileName2.lastIndexOf(".");

            if (pos > -1) {
                extName = fileName2.substring(pos);
                picName = fileName2.substring(0, pos);
            }

            String picPath = "/images/upload/"+id+"/";

            String picFileName = UUID.randomUUID().toString() + extName;

            String basePath = this.getClass().getResource("/").getPath()+"/static/";

            //文件路径
            String filePath = basePath+picPath;

            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            //存储的图片路径
            String picturePath = basePath+picPath+picFileName;
            //数据库的访问路径
            fileName=picPath+picFileName;
            File dest = new File(picturePath);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
                result.put("msg", "IOException e");
                return result;
            }
            Picture picture = new Picture();
            picture.setAlbumId(albumId);//暂用，值从cookie获取
            picture.setPictureCreateTime(new Date());
            picture.setPictureSize((int) dest.length());
            picture.setPictureStatus(1);
            picture.setPictureUrl(fileName);
            picture.setPictureName(picFileName);

            pictureService.insertPicture(picture);

            //获取照片的id
            int pictureId = pictureService.selectPictureId(picFileName);

            //保存tag值,使用百度ai
            tagService.Ai(picturePath,pictureId);
            result.put("code", 0);
            result.put("msg", "创建成功！");
            return result;
        } else {
            result.put("msg", "Unable to upload. File is empty.");
            return result;
        }

    }

    @RequestMapping(value = "/picture/insert")
    public String insert(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/insert";
    }
}