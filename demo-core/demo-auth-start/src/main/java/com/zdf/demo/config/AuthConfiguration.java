package com.zdf.demo.config;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zdf.demo.model.AuthToDo;
import com.zdf.demo.properties.AuthInfo;

@ConditionalOnProperty(prefix="my.info",name="name")
@Configuration
@EnableConfigurationProperties(AuthInfo.class)
public class AuthConfiguration {

	@Resource
	AuthInfo authInfo;
	
	@Bean
	public AuthToDo getAuthToDo() {
		AuthToDo auth=new AuthToDo();
		auth.setDate(authInfo.getDate());
		auth.setName(authInfo.getName());
		auth.setMsg("test spring.factorys");
		return auth;
	}
	
}
