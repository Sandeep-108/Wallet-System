package com.wallet.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.exception.CustomException;
import com.wallet.model.ResponseDto;
import com.wallet.model.User;
import com.wallet.service.UserServiceImpl;

import javassist.NotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/register")
	public ResponseEntity<ResponseDto<User>> registerUser(@RequestBody User user){
		
		return userService.addNewUser(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDto<User>> userLogIn(@RequestParam Map<String, String> body) throws CustomException{
		String email =body.get("email");
		String password= body.get("password");
		return userService.userLogIn(email, password);
	}
	
	@GetMapping("/viewprofile")
	public ResponseEntity<ResponseDto<User>> viewProfile(@RequestParam int userId) throws CustomException{
		
		return userService.viewUserProfile(userId);
	}
	
	@PutMapping("/editprofile")
	public ResponseEntity<ResponseDto<User>> udateProfile(@RequestBody User user) throws CustomException{
		
		return userService.updateUserProfile(user);
	}
	
}
