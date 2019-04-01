package com.wallet.exception;

import java.sql.SQLException;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wallet.model.ResponseDto;
import com.wallet.util.Constants;

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
	public ResponseEntity<ResponseDto<String>> customExceptionHandeler(CustomException wex){
		log.error("ErrorCode: {} , ErrorMsg: {}",wex.getErrorCode(), wex.getMsg());
		ResponseDto<String> walleteExDto= new ResponseDto<String>(wex.getErrorCode(), wex.getMsg(), "Error Occured");
		return new ResponseEntity<>(walleteExDto, HttpStatus.OK);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ResponseDto<String>> nullPointerExceptionHandeler(Exception wex){
		log.error("Exception msg {}", wex.getMessage());
		log.error("{}",wex);
		ResponseDto<String> walleteExDto= new ResponseDto<String>(Constants.SQL_ERROR, "Some thing went wrong", "Error Occured");
		return new ResponseEntity<>(walleteExDto, HttpStatus.OK);
	}
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ResponseDto<String>> EntityExceptionHandeler(Exception wex){
		log.info("Exception msg: Entity not found with id {}", wex.getMessage());
		log.error("stack trace:{}",wex.getStackTrace());
		ResponseDto<String> walleteExDto= new ResponseDto<String>(Constants.NULL_POINTER_EXCEPTIO, "Some thing went wrong", "Error Occured");
		return new ResponseEntity<>(walleteExDto, HttpStatus.OK);
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ResponseDto<String>> sqlExceptionHandeler(Exception wex){
		log.info("Exception msg {}", wex.getMessage());
		log.error("{}",wex);
		ResponseDto<String> walleteExDto= new ResponseDto<String>(Constants.NULL_POINTER_EXCEPTIO, "Some thing went wrong", "Error Occured");
		return new ResponseEntity<>(walleteExDto, HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDto<String>> generalExceptionHandeler(Exception wex){
		log.info("Exception msg {}", wex.getMessage());
		log.error("{}",wex);
		ResponseDto<String> walleteExDto= new ResponseDto<String>(Constants.RUNTIME_EXECEPTION, "Some thing went wrong", "Error Occured");
		return new ResponseEntity<>(walleteExDto, HttpStatus.OK);
	}

}
