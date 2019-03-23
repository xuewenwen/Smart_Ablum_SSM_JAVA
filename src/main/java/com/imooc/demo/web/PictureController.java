package com.imooc.demo.web;

import com.imooc.demo.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class PictureController {
    @Autowired
    PictureService pictureService;

    @RequestMapping(value="/picture/search")
    //   @ResponseBody
    public String Search(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        return "/picture/search";
        //return model;
    }
    @RequestMapping("/picture/search/{tagName}")
    public String selectUrlByTagName(@PathVariable String tagName, ModelMap model, HttpServletRequest request, HttpServletResponse response){
        //String url="";
        List<String> url=pictureService.selectUrlByTagName(tagName);
        model.addAttribute("tag",url);
        return "picture/searchResult";
    }

}
