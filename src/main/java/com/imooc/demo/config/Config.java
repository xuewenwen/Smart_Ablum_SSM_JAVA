package com.imooc.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aiKey")
public class Config {
	
	public String ocrClientId;
	
	public String ocrClientSecret;
	
	public String classifyClientId;
	public String classifyClientSecret;

	public String upladfile;

	public String getClassifyClientId() {
		return classifyClientId;
	}

	public void setClassifyClientId(String classifyClientId) {
		this.classifyClientId = classifyClientId;
	}

	public String getClassifyClientSecret() {
		return classifyClientSecret;
	}

	public void setClassifyClientSecret(String classifyClientSecret) {
		this.classifyClientSecret = classifyClientSecret;
	}

	public String getUpladfile() {
		return upladfile;
	}

	public void setUpladfile(String upladfile) {
		this.upladfile = upladfile;
	}

	public String getOcrClientId() {
		return ocrClientId;
	}

	public void setOcrClientId(String ocrClientId) {
		this.ocrClientId = ocrClientId;
	}

	public String getOcrClientSecret() {
		return ocrClientSecret;
	}

	public void setOcrClientSecret(String ocrClientSecret) {
		this.ocrClientSecret = ocrClientSecret;
	}

	

	
	
	
}
