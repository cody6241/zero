package com.zero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zero.domain.User;
import com.zero.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register.html")
	public String register(){
		return "register";
	}
	
	@ResponseBody
	@RequestMapping(value="/doRegister.html")
	public String doRegister(User user){
		userService.add(user);
		return "success";
	}
}
