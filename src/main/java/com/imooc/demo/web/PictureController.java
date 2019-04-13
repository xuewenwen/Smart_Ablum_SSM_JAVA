package com.imooc.demo.web;

import com.imooc.demo.bo.Picture;
import com.imooc.demo.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
//@RequestMapping(value="/photo")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/ocr", method = RequestMethod.POST)
    @ResponseBody
    public Map ocr(@RequestParam(value = "file_data") MultipartFile file) throws Throwable {
        Map<String, Object> result = new HashMap<String, Object>();

        String user = "user";//暂用
        String fileName = "";//files[0].getSize();
        String msg = "";
        String fileType = "";
        String realFileName;
        if (file != null) {
            String fileName2 = file.getName();
            String filePath = "D:\\helloword\\" + user + "\\";
            File targetFile = new File(filePath);

            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            // fileName = filePath + System.nanoTime() + fileName2 + Math.random()+"."+fileType;
            fileName = filePath + System.nanoTime() + fileName2 + Math.random() + fileType;
            realFileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);

            //File dest = new File(filePath + fileName2 + Math.random());
            File dest = new File(fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
                result.put("msg", "IOException e");
                return result;
            }
            Picture picture = new Picture();
            picture.setAlbumId(1);//暂用，值从cookie获取
            picture.setPictureCreateTime(new Date());
            picture.setPictureSize((int) dest.length());
            picture.setPictureStatus(1);
            picture.setPictureUrl(fileName);
            picture.setPictureName(realFileName);


            pictureService.insertPicture(picture);
            result.put("code", 0);
            result.put("msg", "创建成功！");
            // result.put("pictureId", picture.getPictureId());
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
//    @RequestMapping(value="/multipleSave",method = RequestMethod.POST)
//
//    public @ResponseBody Map<String,Object> multipleSave(@RequestParam(value = "file") MultipartFile[] files){
//        Map<String,Object> result = new HashMap<String,Object>();
//
//        String fileName = "";//files[0].getSize();
//        String msg = "";
//        String user = "2342";//用户名，暂用
//        if(files.length>0){
//
//            try{
//                int i=0;
//                for(MultipartFile file : files){
//                    i++;
//                    if(file!=null){
//
//                        String fileName2 = user+System.nanoTime()+file.getName()+i;
//                        String filePath = "D:\\helloword\\"+user+"\\";
//                        File targetFile = new File(filePath);
//                        if (!targetFile.exists()) {
//                            targetFile.mkdirs();
//                        }
//                        File dest = new File(filePath + fileName2);
//                        file.transferTo(dest);
//                    }
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//                result.put("msg", "IOException e（上传失败）" );
//                return result;
//            }
//        }
//
//        result.put("code",0);
//        result.put("msg",files.length+"个文件上传成功");
//        return result;
//
//    }
//
//}
