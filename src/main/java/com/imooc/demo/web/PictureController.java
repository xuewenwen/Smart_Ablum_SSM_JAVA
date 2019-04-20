package com.imooc.demo.web;

import com.imooc.demo.utils.ImagUtil;
import com.imooc.demo.bo.Picture;
import com.imooc.demo.bo.User;
import com.imooc.demo.service.PictureService;
import com.imooc.demo.service.TagService;
import com.imooc.demo.service.ThreadExecute;
import com.imooc.demo.service.impl.ThreadExecuteImpl;
import org.apache.commons.lang.StringUtils;
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
    @Autowired
    private ThreadExecute threadExecute;

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

            //存放缩略图的路径
            String thumbnailPath = "/images/upload/"+id+"/thumbnail"+"/";

            String picFileName = UUID.randomUUID().toString() + extName;

            String basePath = this.getClass().getResource("/").getPath()+"/static/";

            //文件路径
            String filePath = basePath+picPath;
            //缩略图文件的路径
            String thumbnailFilePath=basePath+thumbnailPath;

            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            //创建缩略图文件夹
            File thumbnailFile = new File(thumbnailFilePath);
            if(!thumbnailFile.exists()){
                thumbnailFile.mkdirs();
            }
            //存储的图片路径
            String picturePath = basePath+picPath+picFileName;

            //将该照片存储到thumbnail路径下，缩略图的工具类会将其覆盖重命名
            String thumbnailPicturePath = basePath+thumbnailPath+picFileName;

            //数据库的访问路径
            fileName=picPath+picFileName;
            File dest = new File(picturePath);
            File pictureThumbnail = new File(thumbnailPicturePath);
            String thumbnailPicPath = "";
            try {
                //保存该图片
                file.transferTo(dest);
                //保存缩略图的原图片路径
                //file.transferTo(pictureThumbnail);
                //存储的缩略图路径
                thumbnailPicPath = ImagUtil.generateThumbnail2Directory(thumbnailFilePath,thumbnailPicturePath);
            } catch (IOException e) {
                e.printStackTrace();
                result.put("msg", "IOException e");
                return result;
            }
            //在数据库存储的缩略图的详细路径
            String thumbnail = StringUtils.substringAfter(thumbnailPicPath,"/static/");
            Picture picture = new Picture();
            picture.setAlbumId(albumId);
            picture.setPictureCreateTime(new Date());
            picture.setPictureSize((int) dest.length());
            picture.setPictureStatus(1);
            picture.setPictureUrl(fileName);
            picture.setPictureName(picFileName);
            picture.setPictureThumbnail(thumbnail);

            pictureService.insertPicture(picture);

            //获取照片的id
            int pictureId = pictureService.selectPictureId(picFileName);

//            //保存tag值,使用百度ai
//            tagService.Ai(picturePath,pictureId);
            //保存百度ai中的tag值，使用线程池的方法
            threadExecute.Execute(picturePath,pictureId);
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