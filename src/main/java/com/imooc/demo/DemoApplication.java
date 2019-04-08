package com.imooc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication//开启组件扫描和自动配置的注解
public class DemoApplication extends SpringBootServletInitializer {

	@Override
	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application){
		return  application.sources(DemoApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//向SpringApplication.run传一个DemoApplication类的参数来启动demo
	}


}
