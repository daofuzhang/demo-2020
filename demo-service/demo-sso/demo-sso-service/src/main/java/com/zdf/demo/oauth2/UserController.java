package com.zdf.demo.oauth2;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@GetMapping("/user")
	public @ResponseBody Principal user(Principal user){
		return user;
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
