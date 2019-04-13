//package com.imooc.demo.utils;
//
//import com.imooc.demo.config.Config;
//import com.imooc.demo.config.ConfigURL;
//import com.imooc.demo.core.AccessToken;
//import com.imooc.demo.service.TagService;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.BufferedOutputStream;
//import java.io.FileOutputStream;
//import java.net.URLEncoder;
//
//public class AiUtil {
//    public static String Ai(String path, MultipartFile file){
//        try {
//            String relst = "";
//            Config orc;
//            // 这里只是简单例子，文件直接输出到项目路径下。
//            // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
//            // 还有关于文件格式限制、文件大小限制，详见：中配置。
//            BufferedOutputStream out = new BufferedOutputStream(
//                    new FileOutputStream(path));
//            out.write(file.getBytes());
//            out.flush();
//            out.close();
//            byte[] imgData = FileUtil.readFileByBytes(path);
//            String imgStr = Base64Util.encode(imgData);
//            relst = URLEncoder.encode("image", "UTF-8") + "="    + URLEncoder.encode(imgStr, "UTF-8");
//            /**
//             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
//             */
//            String accessToken = AccessToken.getAuth(orc.getClassifyClientId(),orc.getClassifyClientSecret());
//            String par = ConfigURL.classifyUrl;
//            String result = HttpUtil.post(par, accessToken, relst);
//            String w = "";
//            JSONObject js = new JSONObject(result);
//            JSONArray jsonArray = js.getJSONArray("result");
//            for (int i = 0; i < jsonArray.length(); i++) {
//                double score = jsonArray.getJSONObject(i).getDouble("score");
//                String keyword = jsonArray.getJSONObject(i).getString("keyword");
//                w += "名称：&nbsp;&nbsp;"+keyword+"&nbsp;&nbsp;&nbsp;置信度:&nbsp;&nbsp;&nbsp;"+score+"<br><br>";
//                if(score>0.5) {
//                    TagService.tagService.insertTag(keyword, 14);
//                }
//            }
//            return w;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "失败";
//    }
//
//    }
//}
