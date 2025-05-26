package com.like.core.web.response;

import java.util.List;

import lombok.Data;

@Data
public class ApiResponseList {

	List<?> data;	
	
	String message;
	
	public ApiResponseList(List<?> data, String message) {
		this.data = data;		
		this.message = message;
	}
}
