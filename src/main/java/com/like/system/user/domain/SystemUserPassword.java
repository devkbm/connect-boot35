package com.like.system.user.domain;

import java.io.Serializable;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Embeddable
public class SystemUserPassword implements Serializable {
	
	private static final long serialVersionUID = 5831655386795107265L;
	
	private static final String INIT_PASSWORD = "12345678";	
	public static String getInitPassword() {
		return INIT_PASSWORD;
	}
	
	@Column(name="pwd")
	String password;		
	
	/*
	boolean isEqual(String password) {
		return this.password.equals(password);
	}
	*/
	
	void set(PasswordEncoder encoder, String rawPassword) {
		this.password = encoder.encode(rawPassword);
	}
	
	void change(PasswordEncoder encoder, String beforePassword, String afterPassword) {				
		if (encoder.matches(beforePassword, this.password)) {
			this.set(encoder, afterPassword);
		}
	}
			
}
