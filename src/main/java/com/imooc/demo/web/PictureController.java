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

    //@Autowired
    //PhotoDao photoDao;
    //http://url/photo/photoid

  /*  @RequestMapping(value = "/picture/{pictureId}")
    public String show(@PathVariable int pictureId,
                              ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Picture picture = pictureService.getPicture(pictureId);
        model.put("p", picture);

        return "picture/show";
    }*/


   /* @RequestMapping(value = "/ocr", method = RequestMethod.POST)
    public Map ocr(MultipartFile file) throws Exception {
        //接收图像二进制数据
        byte[] buf = file.getBytes();
        //参数解密
        String key = "love10240wsw";
        EncryptUtil des = new EncryptUtil(key, "utf-8");
        //初始化百度接口
        AipOcr client = new AipOcr(des.deCode(AIP.APP_ID_TEXT),des.deCode(AIP.API_KEY_TEXT),des.deCode(AIP.SECRET_KEY_TEXT));
        //首选参数
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        //中英语言
        JSONObject res = client.basicGeneral(buf, options);
        Map map = JSONChange.json2map(res.toString());
        System.out.println(res.toString());
        return map;
    }*/


    @RequestMapping(value = "/ocr", method = RequestMethod.POST)
    @ResponseBody
    public Map ocr(@RequestParam(value = "file_data") MultipartFile file) throws Throwable {





        Map<String,Object> result = new HashMap<String,Object>();

        String user = "user";//暂用
        String fileName = "";//files[0].getSize();
        String msg = "";
        String fileType="";
        String realFileName;
        if(file!=null){
            String fileName2 = file.getName();
            fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String filePath = "D:\\helloword\\"+user + "\\";
            File targetFile = new File(filePath);

            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
           // fileName = filePath + System.nanoTime() + fileName2 + Math.random()+"."+fileType;
            fileName =filePath + System.nanoTime() +fileName2+Math.random()+"."+fileType;
            realFileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);

            //File dest = new File(filePath + fileName2 + Math.random());
            File dest = new File(fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
                result.put("msg", "IOException e" );
                return result;
            }

            /* if (files != null && files.length >0) {*/
            // if (files[0].getSize()>0) {
          /*  for(int i =0 ;i< files.length; i++){
                try {
                    fileName = files[i].getOriginalFilename();
                    byte[] bytes = files[i].getBytes();
                    BufferedOutputStream buffStream =
                            new BufferedOutputStream(new FileOutputStream(new File("/tmp/" + fileName)));
                    buffStream.write(bytes);
                    buffStream.close();
                    msg += "You have successfully uploaded " + fileName;
                } catch (Exception e) {
                    result.put("msg", "You failed to upload " + fileName + ": " + e.getMessage());
                }
            }*/
          
          /*向*/
            Picture picture = new Picture();
            picture.setAlbumId(1);//暂用，值从cookie获取
            //picture.setPictureDescription("fvwavwsrgrw");
            picture.setPictureCreateTime(new Date());
            picture.setPictureSize((int)dest.length());
            picture.setPictureStatus(1);
            picture.setPictureUrl(fileName);
            picture.setPictureName(realFileName);


            pictureService.insertPicture(picture);
            result.put("code", 0);
            result.put("msg", "创建成功！");
            // result.put("pictureId", picture.getPictureId());
            return result;
        } else {
            result.put("msg", "Unable to upload. File is empty." );
            return result;
        }






    }






    @RequestMapping(value = "/picture/insert")
    public String insert(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/insert";
    }

    /*@RequestMapping(value = "/picture/doInsert")
    @ResponseBody
    public Map<String,Object> doInsert(Picture picture, ModelMap model,
                                       HttpServletRequest request, HttpServletResponse response,
                                       @Param("pictureDescription") String pictureDescription
                                        ,@Param(value="formdata") MultipartFile[] file) throws Exception {
        //photo.setPhotoName("清明上河");@RequestParam("file") MultipartFile[] files formdata
        //photo.setUserId(1L);

        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        m.addAttribute("pictureCreateTime",new Date());//df.format(new Date())
//
//        m.addAttribute("pictureStatus",1);
//        m.addAttribute("albumId",2);//需要改
//        m.addAttribute("pictureTag",2);//需要改
//
//        m.addAttribute("pictureThumbnaill","destFileName");//需要改
//        m.addAttribute("pictureDescribtion","pictureDescribtion");
//

       *//* String destFileName="";//图片的url
        File destFile;
        try {
            //其中字符串user是姓名，需要改为登陆的名字

            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            //String fileName = System.currentTimeMillis() + file.getOriginalFilename();//这个是源路径
            String fileName = System.currentTimeMillis() +"users" +file.getName();

            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            destFileName = request.getServletContext().getRealPath("") + "upload" +File.separator+"users"+ File.separator + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用
            //m.addAttribute("fileName", fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
           // return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            //return "上传失败," + e.getMessage();
        }*//*
       
     //   m.addAttribute("pictureUrl",destFileName);
      //  m.addAttribute("pictureSize",destFile.length());


        picture.setPictureTag("nw");
     //  picture.setPictureSize(destFileName.length());
       *//* if(destFileName.equals(""))
            destFileName = "cuole";
        else
         picture.setPictureUrl(destFileName);*//*
       if(file==null){
           picture.setPictureSize(11111);
       }else{
           int length =(int)file.length;
           picture.setPictureSize(length);
       }


        picture.setPictureCreateTime(new Date());
        //picture.setAlbumId(22);//最后需要改为session中的值
        picture.setPictureDescription(pictureDescription);
        int count = pictureService.insertPicture(picture);


        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code", 0);
        result.put("msg", "创建成功！");
        result.put("pictureId", picture.getPictureId());
        return result;
    }*/

    @RequestMapping(value="/multipleSave",method = RequestMethod.POST)

  //  public @ResponseBody Map<String,Object> multipleSave(@Param("formdata") MultipartFile[] files){
    public @ResponseBody Map<String,Object> multipleSave(@RequestParam(value = "file") MultipartFile[] files){
        Map<String,Object> result = new HashMap<String,Object>();

        /*for(MultipartFile file : files){

        }*/
        String fileName = "";//files[0].getSize();
        String msg = "";
        /*if(file!=null){
            String fileName2 = file.getName();
            String filePath = "D:\\helloword\\";
            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            File dest = new File(filePath + fileName2);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
                result.put("msg", "IOException e" );
                return result;
            }

            */
        /* if (files != null && files.length >0) {*//*
            // if (files[0].getSize()>0) {
          */
        /*  for(int i =0 ;i< files.length; i++){
                try {
                    fileName = files[i].getOriginalFilename();
                    byte[] bytes = files[i].getBytes();
                    BufferedOutputStream buffStream =
                            new BufferedOutputStream(new FileOutputStream(new File("/tmp/" + fileName)));
                    buffStream.write(bytes);
                    buffStream.close();
                    msg += "You have successfully uploaded " + fileName;
                } catch (Exception e) {
                    result.put("msg", "You failed to upload " + fileName + ": " + e.getMessage());
                }
            }*/
        /*

            result.put("code", 0);
            result.put("msg", "创建成功！");
            // result.put("pictureId", picture.getPictureId());
            return result;
        } else {
            result.put("msg", "Unable to upload. File is empty." );
            return result;
        }*/

        String user = "2342";//用户名，暂用
        if(files.length>0){

            try{
                int i=0;
                for(MultipartFile file : files){
                    i++;
                    if(file!=null){

                        String fileName2 = user+System.nanoTime()+file.getName()+i;
                        String filePath = "D:\\helloword\\"+user+"\\";
                        File targetFile = new File(filePath);
                        if (!targetFile.exists()) {
                            targetFile.mkdirs();
                        }
                        File dest = new File(filePath + fileName2);
                        file.transferTo(dest);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
                result.put("msg", "IOException e（上传失败）" );
                return result;
            }
        }

        result.put("code",0);
        result.put("msg",files.length+"个文件上传成功");
        return result;

    }

    /*@ResponseBody
    public String photoDetail(@PathVariable Long photoId,
                              HttpServletRequest request, HttpServletResponse response) throws Exception {
        Photo photo = photoService.getPhoto(photoId);
        return photo.getPhotoName();
    }*/
}
