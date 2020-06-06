package com.zdf.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zdf.demo.config.EnableMyOwnBeanDefinitions;

@SpringBootApplication
@EnableMyOwnBeanDefinitions
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
