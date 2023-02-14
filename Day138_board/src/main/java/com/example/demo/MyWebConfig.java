package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 설정파일 클래스 지정
public class MyWebConfig implements WebMvcConfigurer {
	
	//for linux
	static final public String savePath = "/usr/upload";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/upload/");
		registry.addResourceHandler("/upload/**").addResourceLocations("file:/usr/upload/");
	}
	
}
