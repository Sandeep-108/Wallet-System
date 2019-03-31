package com.wallet.service;

import org.springframework.http.ResponseEntity;

import com.wallet.exception.CustomException;
import com.wallet.model.ResponseDto;
import com.wallet.model.User;

public interface UserService {
	
	public ResponseEntity<ResponseDto<User>> addNewUser(User user) ;
	
	public ResponseEntity<ResponseDto<User>> userLogIn(String email, String password) throws CustomException;
	
	public ResponseEntity<ResponseDto<User>> viewUserProfile(int userId) throws CustomException;
	
	public ResponseEntity<ResponseDto<User>> updateUserProfile(User user) throws CustomException;

}
