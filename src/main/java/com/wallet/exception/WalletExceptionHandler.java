package com.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wallet.model.ResponseDto;

@RestControllerAdvice
public class WalletExceptionHandler {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ResponseDto<String>> walletExceptionHandeler(CustomException wex){
		ResponseDto<String> walleteExDto= new ResponseDto<String>(wex.getErrorCode(), wex.getMsg(), "Error Occured");
		return new ResponseEntity<>(walleteExDto, HttpStatus.OK);
	}

}
