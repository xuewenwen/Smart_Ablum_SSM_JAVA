package com.imooc.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		//返回Hello SpringBoot!
		return "Hello SpringBoot!";
	}
}
