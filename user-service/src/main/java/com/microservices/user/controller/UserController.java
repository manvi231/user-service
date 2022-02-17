package com.microservices.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.user.VO.ResponseTemplateVO;
import com.microservices.user.entity.User;
import com.microservices.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside Save User Controller: " + user);
		return userService.saveUser(user);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseTemplateVO findUserWithDepartment(@PathVariable(name = "userId")  Long userId) {
		log.info("Inside Find User Controller: " + userId);
		return userService.findUserWithDepartment(userId);
	}
	
	
//	@GetMapping("/{userId}")
//	public User findUserById(@PathVariable(name = "userId")  Long userId) {
//		log.info("Inside Find User Controller: " + userId);
//		return userService.findByUserId(userId);
//	}
	

}
