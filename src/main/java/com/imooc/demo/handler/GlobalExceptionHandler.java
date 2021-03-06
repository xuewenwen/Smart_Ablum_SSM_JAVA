package com.imooc.demo.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 * 
 * @author xiangze
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Throwable.class)
	@ResponseBody
	public Map<String, Object> exceptionHandler(HttpServletRequest req, Throwable e) throws Throwable {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", false);
		modelMap.put("errMsg", e.getMessage());
		if (e!=null) {
			e.printStackTrace();
		}
		return modelMap;
	}

}