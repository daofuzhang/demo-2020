package com.zdf.demo.config;

import org.springframework.context.annotation.Bean;
import com.zdf.demo.service.TestServiceA;

public class UserBeansConfig {

	@Bean
	public TestServiceA testServiceA() {
		return new TestServiceA();
	}
}
