package com.wallet.exception;
/**
 * 
 * @author sandy
 *
 */
public class CustomException extends Exception{

	private String errorCode;
	private String msg;
	
	public CustomException() {
		
	}
	public CustomException(String errorCode, String msg) {
		this.errorCode = errorCode;
		this.msg = msg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
