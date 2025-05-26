package com.like.core.web.response;

import java.util.Map;

import lombok.Data;

@Data
public class ApiResponseMap<K, V> {

	Map<K, V> data;	
	
	String message;
	
	public ApiResponseMap(Map<K, V> data, String message) {
		this.data = data;		
		this.message = message;
	}
}
