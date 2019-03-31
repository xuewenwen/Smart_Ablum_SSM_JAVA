package com.imooc.demo.web;

import com.imooc.demo.config.Config;
import com.imooc.demo.config.ConfigURL;
import com.imooc.demo.core.AccessToken;
import com.imooc.demo.service.TagService;
import com.imooc.demo.utils.Base64Util;
import com.imooc.demo.utils.FileUtil;
import com.imooc.demo.utils.HttpUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;


/**
 * 图像识别
  * @className: ClassifyController
  * @description:
  * @author: singleton-zw
  * @createDate: 2018年2月2日-上午9:59:10
  * @updateAuthor:
  * @updateDate:
  * @updateDesc:
  * @version: v1.2.0
  * @Copyright (c)-2018
 */
@Controller
@RequestMapping("/classify")
public class ClassifyController {
	
	@Autowired
	public Config orc;
	@Autowired
	public TagService tagService;
	@RequestMapping("/")
	public String classify(){
		return "/classify";
	}
	

	/**
	 * 动物识别
	 * @methodsDescription:
	 * @methodName: rec
	 * @param file
	 * @return
	 * @author: singleton-zw
	 * @return: String
	 */
	@RequestMapping(value="/animal" ,method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String rec(@RequestParam("animalfile") MultipartFile file){
		if (file.isEmpty()) {
			return "文件不能为空";
		}
		String path = orc.getUpladfile()+file.getOriginalFilename();
		String relst = "";
		try {
            // 这里只是简单例子，文件直接输出到项目路径下。
            // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
            // 还有关于文件格式限制、文件大小限制，详见：中配置。
            BufferedOutputStream out = new BufferedOutputStream(
                    new FileOutputStream(path));
            out.write(file.getBytes());
            out.flush();
            out.close();
            
            byte[] imgData = FileUtil.readFileByBytes(path);
            String imgStr = Base64Util.encode(imgData);
            relst = URLEncoder.encode("image", "UTF-8") + "="    + URLEncoder.encode(imgStr, "UTF-8");
          /**
          * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
          */
         String accessToken = AccessToken.getAuth(orc.getClassifyClientId(),orc.getClassifyClientSecret());
         String par = ConfigURL.classifyUrl;
//         if(types.equals("1")){
//        	 par = ConfigURL.classifyUrl;
//         }else  if(types.equals("2")){
//        	 par = ConfigURL.plantUrl;
//         }else  if(types.equals("3")){
//        	 par = ConfigURL.carUrl;
//         }
         String result = HttpUtil.post(par, accessToken, relst);
//         System.out.println(result);
//         {"log_id": 6765644061838946718, "result": [{"score": "0.809126", "name": "金毛犬"}, {"score": "0.0676504", "name": "拉布拉多"}, {"score": "0.00950747", "name": "北极熊"}, {"score": "0.00729283", "name": "棕熊"}, {"score": "0.00436323", "name": "可卡"}, {"score": "0.00338853", "name": "中华田园犬"}]}
         String w = "";
         JSONObject js = new JSONObject(result);
         JSONArray jsonArray = js.getJSONArray("result");
        for (int i = 0; i < jsonArray.length(); i++) {
			double score = jsonArray.getJSONObject(i).getDouble("score");
			String keyword = jsonArray.getJSONObject(i).getString("keyword");
			w += "名称：&nbsp;&nbsp;"+keyword+"&nbsp;&nbsp;&nbsp;置信度:&nbsp;&nbsp;&nbsp;"+score+"<br><br>";
			if(score>0.1) {
				tagService.insertTag(keyword, 14);
			}
		}
         return w;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "失败";
	}
}
