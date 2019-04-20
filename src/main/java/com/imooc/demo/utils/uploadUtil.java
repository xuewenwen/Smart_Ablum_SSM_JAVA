package com.imooc.demo.utils;

import com.imooc.demo.bo.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class uploadUtil {
    public File upload(int id, int albumId, MultipartFile file, String picPath) {
        String fileName = "";
        String msg = "";
        String fileType = "";
        String realFileName;
        String fileName2 = file.getOriginalFilename();
        String picName = fileName2;
        String extName = "";
        int pos = fileName2.lastIndexOf(".");
        if (pos > -1) {
            extName = fileName2.substring(pos);
            picName = fileName2.substring(0, pos);
        }
        // String picPath = "/images/"+"cover"+"/" + id + "/";
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
        //album.setAlbumCover(fileName);
        File dest = new File(picturePath);
        return dest;

    }
}
