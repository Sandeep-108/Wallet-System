package com.wallet.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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
import com.wallet.util.Constants;

/**
 * 
 * @author sandy
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 * @param user
	 * @return ResponseEntity
	 */
	@PostMapping("/register")
	public ResponseEntity<ResponseDto<User>> registerUser(@RequestBody User user){
		log.info("Register user request: {}",user);
		return userService.addNewUser(user);
	}
	/**
	 * 
	 * @param body
	 * @return ResponseEntity
	 * @throws CustomException
	 */
	@PostMapping("/login")
	public ResponseEntity<ResponseDto<User>> userLogIn(@RequestParam Map<String, String> body) throws CustomException{
		log.info("Login user request: {}",body);
		String email =body.get("email");
		String password= body.get("password");
		return userService.userLogIn(email, password);
	}
	/**
	 * 
	 * @param userId
	 * @return ResponseEntity
	 * @throws CustomException
	 */
	@GetMapping("/viewprofile")
	public ResponseEntity<ResponseDto<User>> viewProfile(@RequestParam int userId) throws CustomException{
		MDC.clear();
		MDC.put(Constants.USER_ID, String.valueOf(userId));
		log.info("Viewprofile user request: {}",userId);
		return userService.viewUserProfile(userId);
	}
	/**
	 * 
	 * @param user
	 * @return ResponseEntity
	 * @throws CustomException
	 */
	@PutMapping("/editprofile")
	public ResponseEntity<ResponseDto<User>> udateProfile(@RequestBody User user) throws CustomException{
		MDC.clear();
		MDC.put(Constants.USER_ID, String.valueOf(user.getUserId()));
		log.info("Edit Profile user request: {}",user);
		return userService.updateUserProfile(user);
	}
	
}
