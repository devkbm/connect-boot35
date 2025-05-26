package com.like.core.web.response;

import lombok.Data;

@Data
public class ApiResponseObject<T> {
	
	T data;
			
	String message;	
	
	public ApiResponseObject(T data, String message) {
		this.data = data;			
		this.message = message;
	}
}
