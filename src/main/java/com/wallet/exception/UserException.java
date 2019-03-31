package com.wallet.exception;

public class UserException extends Exception{

	private int errorCode;
	private String msg;
	
	public UserException() {
		
	}
	public UserException(int errorCode, String msg) {
		this.errorCode = errorCode;
		this.msg = msg;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}