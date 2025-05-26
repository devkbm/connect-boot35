package com.like.core.security.oauth2;

public class OAuth2LoginRequestThreadLocal {

	private static final ThreadLocal<String> LOGIN_THREAD_LOCAL = new ThreadLocal<>();
	
	public static void set(String companyCode) {
		LOGIN_THREAD_LOCAL.set(companyCode);
	}
	
	public static String get() {
		return LOGIN_THREAD_LOCAL.get();
	}
	
	public static void remove() {
		LOGIN_THREAD_LOCAL.remove();
	}
}
