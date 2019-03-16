package com.imooc.demo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.demo.bo.Area;
import com.imooc.demo.service.AreaService;

@RestController
/*@RequestMapping("/superadmin")*/
public class AreaController {
	@Autowired
	private AreaService areaService;

	/**
	 * 获取所有的区域信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listarea", method = RequestMethod.GET)
	private Map<String, Object> listArea() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Area> list = new ArrayList<Area>();
		// 获取区域列表
		list = areaService.getAreaList();
		modelMap.put("areaList", list);
		return modelMap;
	}

	/**
	 * 通过区域Id获取区域信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
	private Map<String, Object> getAreaById(Integer areaId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取区域信息
		Area area = areaService.getAreaById(areaId);
		modelMap.put("area", area);
		return modelMap;
	}

	/**
	 * 添加区域信息
	 * 
	 * @param areaStr
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = "/addarea", method = RequestMethod.POST)
	private Map<String, Object> addArea(@RequestBody Area area)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 添加区域信息
		modelMap.put("success", areaService.addArea(area));
		return modelMap;
	}

	/**
	 * 修改区域信息，主要修改名字
	 * 
	 * @param areaStr
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
	private Map<String, Object> modifyArea(@RequestBody Area area)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", areaService.modifyArea(area));
		return modelMap;
	}

	@RequestMapping(value = "/removearea", method = RequestMethod.GET)
	private Map<String, Object> removeArea(Integer areaId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", areaService.deleteArea(areaId));
		return modelMap;
	}

}
