package com.biz.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.biz.book.interceptor.LoginAuthInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.biz.book.controller","com.biz.book.service"})
public class AppServletConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/files/**").addResourceLocations("/files/");
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		
		multipartResolver.setMaxUploadSize(10000000);
		multipartResolver.setMaxUploadSizePerFile(1000000);
		
		return multipartResolver;
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
}














