package com.like.core.web.util;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.like.core.web.response.ApiResponseObject;
import com.like.core.web.response.ApiResponseList;
import com.like.core.web.response.ApiResponseMap;

public abstract class ResponseEntityUtil {		
			
	public static ResponseEntity<ApiResponseList> toList(List<?> data, String message, HttpStatus httpStatus) {
		
		ApiResponseList obj = new ApiResponseList(data, message);			      
	    
	    return new ResponseEntity<ApiResponseList>(obj, getResponseHeaders(), httpStatus);	    	    	    	    	
	}
	
	public static ResponseEntity<ApiResponseList> toList(List<?> data, String message) {
		
		ApiResponseList obj = new ApiResponseList(data, message);			      
	    
	    return new ResponseEntity<ApiResponseList>(obj, getResponseHeaders(), HttpStatus.OK);	    	    	    	    	
	}
			
	public static<T> ResponseEntity<ApiResponseObject<T>> toOne(T data, String message, HttpStatus httpStatus) {
		ApiResponseObject<T> obj = new ApiResponseObject<T>(data, message);
		
		return new ResponseEntity<ApiResponseObject<T>>(obj, getResponseHeaders(), httpStatus);
	}
	
	public static<T> ResponseEntity<ApiResponseObject<T>> toOne(T data, String message) {
		ApiResponseObject<T> obj = new ApiResponseObject<T>(data, message);
		
		return new ResponseEntity<ApiResponseObject<T>>(obj, getResponseHeaders(), HttpStatus.OK);
	}
		
	public static<K, V> ResponseEntity<ApiResponseMap<K, V>> toMap(Map<K, V> data, String message, HttpStatus httpStatus) {
		ApiResponseMap<K, V> obj = new ApiResponseMap<K, V>(data, message);
		
		return new ResponseEntity<ApiResponseMap<K, V>>(obj, getResponseHeaders(), httpStatus);
	}
	
	public static<K, V> ResponseEntity<ApiResponseMap<K, V>> toMap(Map<K, V> data, String message) {
		ApiResponseMap<K, V> obj = new ApiResponseMap<K, V>(data, message);
		
		return new ResponseEntity<ApiResponseMap<K, V>>(obj, getResponseHeaders(), HttpStatus.OK);
	}
	
	private static HttpHeaders getResponseHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return responseHeaders;		
	}		 
	
}
