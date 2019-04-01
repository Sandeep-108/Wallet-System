package com.wallet.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wallet.model.ResponseDto;

/**
 * 
 * @author sandy
 *
 */
@RestControllerAdvice
public class WalletExceptionHandler {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 * @param wex
	 * @return ResponseEntity
	 */
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ResponseDto<String>> walletExceptionHandeler(CustomException wex){
		log.error("ErrorCode: {} , ErrorMsg: {}",wex.getErrorCode(), wex.getMsg());
		ResponseDto<String> walleteExDto= new ResponseDto<String>(wex.getErrorCode(), wex.getMsg(), "Error Occured");
		return new ResponseEntity<>(walleteExDto, HttpStatus.OK);
	}

}
