package com.imooc.demo.service;

import com.imooc.demo.bo.Area;

import java.util.List;

public interface PictureService {
	public List<String> selectUrlByTagName(String tagName,Integer id);

}
