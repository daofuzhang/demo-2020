package com.zdf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zdf.demo.service.TestServiceA;
import com.zdf.demo.service.TestServiceB;

@RestController
public class TestController {

	@Autowired
	private TestServiceA testServiceA;
	
	@Autowired
	private TestServiceB testServiceB;
	
	@RequestMapping("/test")
	public String test() {
		return testServiceA.getTest();
	}
	
	@RequestMapping("/test2")
	public String test2() {
		return testServiceB.getTest();
	}
	
	
}
