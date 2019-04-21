package com.imooc.demo.service.impl;

import com.imooc.demo.bo.PicTag;
import com.imooc.demo.bo.Tag;
import com.imooc.demo.config.Config;
import com.imooc.demo.config.ConfigURL;
import com.imooc.demo.core.AccessToken;
import com.imooc.demo.dao.TagDao;
import com.imooc.demo.service.TagService;
import com.imooc.demo.utils.Base64Util;
import com.imooc.demo.utils.FileUtil;
import com.imooc.demo.utils.HttpUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;
    @Autowired
    public Config orc;

    @Override
    public void insertTag(String name, Integer id) throws Exception {
        PicTag picTag = new PicTag();
        Tag tag = new Tag();
        //String name = "小猪";
        Integer num = tagDao.selectCountTag(name);
        if (num != null) {
            picTag.setPictureId(id);
            picTag.setTagId(num);
            tagDao.insertPicTag(picTag);
        } else {
            tag.setTagName(name);
            tagDao.insertTag(tag);
            picTag.setPictureId(id);
            picTag.setTagId(tagDao.selectCountTag(name));
            tagDao.insertPicTag(picTag);
        }
    }

    @Override
    public void Ai(String path, Integer id) {
        //id为图片id
       // Config orc;
        try {
            String relst = "";
            //Config orc;
            byte[] imgData = FileUtil.readFileByBytes(path);
            String imgStr = Base64Util.encode(imgData);
            relst = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            String accessToken = AccessToken.getAuth(orc.getClassifyClientId(), orc.getClassifyClientSecret());
            String par = ConfigURL.classifyUrl;
            String result = HttpUtil.post(par, accessToken, relst);
            String w = "";
            JSONObject js = new JSONObject(result);
            JSONArray jsonArray = js.getJSONArray("result");
            int j=0;
            while (j<5){
                if(!js.has("error_msg")) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        double score = jsonArray.getJSONObject(i).getDouble("score");
                        String keyword = jsonArray.getJSONObject(i).getString("keyword");
                        if (score > 0.3) {
                            insertTag(keyword, id);
                        }
                    }
                    break;
                }
                    j++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
