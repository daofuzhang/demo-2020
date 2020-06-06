package com.zdf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zdf.demo.model.AuthToDo;

@RestController
public class TestFactoryController {

	@Autowired
	private AuthToDo authToDo;
	
	@RequestMapping("/test")
	public String test() {
		return authToDo.getName();
	}
}
