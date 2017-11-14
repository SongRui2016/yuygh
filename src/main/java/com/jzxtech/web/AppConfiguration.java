package com.jzxtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.jzxtech.web.interceptor.LoginInterceptor;
import com.jzxtech.web.spring.WebMvcConfiguration;

@Configuration
@Primary
public class AppConfiguration extends WebMvcConfiguration {

	@Autowired
	private LoginInterceptor loginInterceptor;

    @Override  
    public void addInterceptors(InterceptorRegistry registry) {  
        registry.addInterceptor(loginInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns("/login/login")
        ;
    }

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedMethods("*")
		.allowedHeaders("*")
		.exposedHeaders("Access-Control-Allow-Headers", "Access-Control-Allow-Methods", "Access-control-Allow-Origin", "Access-Control-Max-Age", "X-Frame-Options")
		.allowCredentials(true)
		.maxAge(3600);
	}

}
