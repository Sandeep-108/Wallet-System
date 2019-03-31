package com.wallet.model;

public class ResponseDto<T> {

	private String code;
	private String description;
	private T data;
	
	public ResponseDto(){
		
	}
	public ResponseDto(String code, String description, T data) {
		this.code = code;
		this.description = description;
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
