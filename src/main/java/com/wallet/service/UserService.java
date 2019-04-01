package com.wallet.service;

import org.springframework.http.ResponseEntity;

import com.wallet.exception.CustomException;
import com.wallet.model.ResponseDto;
import com.wallet.model.User;
/**
 * 
 * @author sandy
 *
 */
public interface UserService {
	/**
	 * 
	 * @param user
	 * @return ResponseEntity
	 */
	public ResponseEntity<ResponseDto<User>> addNewUser(User user) ;
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws CustomException
	 */
	public ResponseEntity<ResponseDto<User>> userLogIn(String email, String password) throws CustomException;
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws CustomException
	 */
	public ResponseEntity<ResponseDto<User>> viewUserProfile(int userId) throws CustomException;
	/**
	 * 
	 * @param user
	 * @return
	 * @throws CustomException
	 */
	public ResponseEntity<ResponseDto<User>> updateUserProfile(User user) throws CustomException;

}
