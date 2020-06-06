package com.zdf.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.zdf.demo.config.AuthConfiguration;

@Configuration
@Import({AuthConfiguration.class})
public class AuthConfig {

}
