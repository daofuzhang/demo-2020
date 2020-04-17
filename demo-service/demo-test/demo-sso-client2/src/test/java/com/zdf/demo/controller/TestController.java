package com.zdf.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test02")
public class TestController {

	@GetMapping("/hello")
	public String test() {
		return "hello world！";
	}
}
