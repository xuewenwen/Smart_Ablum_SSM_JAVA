package com.imooc.demo.web;


import com.imooc.demo.service.*;
import com.imooc.demo.utils.ImagUtil;
import com.imooc.demo.bo.Picture;
import com.imooc.demo.bo.User;
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
import javax.swing.*;
import java.io.*;
import java.net.URLEncoder;
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
    @Autowired
    private AlbumService albumService;
    @Autowired
    private UserService userService;

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
            } catch (IOException e) {
                e.printStackTrace();
                result.put("msg", "FileUploadException e");
                return result;
            }
            ImageIcon icon = new ImageIcon(picturePath);
            int imageWidth = icon.getIconWidth();
            int imageHeight = icon.getIconHeight();
                //保存缩略图的原图片路径

            double shrinkWidth = 200;
            double shrinkHeight = 150;
           if(shrinkWidth < imageWidth)
               shrinkWidth /=  imageWidth;
           else shrinkWidth=1;
            if(shrinkHeight < imageHeight)
                shrinkHeight /=  imageHeight;
            else shrinkWidth=1;
                //file.transferTo(pictureThumbnail);
                //存储的缩略图路径
            try{
                thumbnailPicPath = com.imooc.demo.utils.ImagUtil.generateThumbnail2Directory(shrinkWidth,shrinkHeight,thumbnailFilePath,picturePath);
            }catch (IOException e){
                e.printStackTrace();
                result.put("msg", "ConvertToThumbnailException e");
            }


            //在数据库存储的缩略图的详细路径
            //这步是将从imageutil中获取的路径值的图片名获取下来
            String thumbnail = StringUtils.substringAfter(thumbnailPicPath,"/"+id+"/");
            //数据库的完整路径
            String thumbnailPicture = thumbnailPath+thumbnail;
            Picture picture = new Picture();
            picture.setAlbumId(albumId);
            picture.setPictureCreateTime(new Date());
            picture.setPictureSize((int) dest.length());
            picture.setPictureStatus(1);
            picture.setPictureUrl(fileName);
            picture.setPictureName(picFileName);
            picture.setPictureThumbnail(thumbnailPicture);

            pictureService.insertPicture(picture);

            //相册的照片数加1
            albumService.updateAlbumNum(albumId);
            //更新用户的空间大小
            Long size = dest.length();
            userService.updateSize(size,id);

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

    /*@RequestMapping(value="/downd")
    public void download(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //logger.info("ajax download file");
        String fileName = req.getParameter("fileName");
        File file = new File(System.getProperty("user.home"), fileName);

        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition","attachment;filename=" + fileName);
        resp.setContentLength((int) file.length());

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] buffer = new byte[128];
            int count = 0;
            while ((count = fis.read(buffer)) > 0) {
                resp.getOutputStream().write(buffer, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            resp.getOutputStream().flush();
            resp.getOutputStream().close();
            fis.close();
        }

    }*/





    //实现Spring Boot 的文件下载功能，映射网址为/download
    @RequestMapping("/downloaded")
    public String downloadFile(HttpServletRequest request,
                               HttpServletResponse response) throws UnsupportedEncodingException {

        // 获取指定目录下的第一个文件
        File scFileDir = new File("D:\\沉泣.jpg");
        File TrxFiles[] = scFileDir.listFiles();
        //System.out.println(TrxFiles[0]);
        String fileName = TrxFiles[0].getName(); //下载的文件名

        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            String realPath = "E://mubu/";
            File file = new File(realPath, fileName);

            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("Download the song successfully!");
                }
                catch (Exception e) {
                    System.out.println("Download the song failed!");
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }


}