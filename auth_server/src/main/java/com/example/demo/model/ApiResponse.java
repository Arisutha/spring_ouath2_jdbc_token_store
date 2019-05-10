package com.example.demo.model;

import lombok.Data;

@Data
public class ApiResponse {
	private Integer status;
	private String message;
	private Object result;

	public ApiResponse() {
	}
	
	public ApiResponse (Integer status, String message, Object result) {
		this.status = status;
		this.message = message;
		this.result = result;
	}

	public ApiResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}
}
