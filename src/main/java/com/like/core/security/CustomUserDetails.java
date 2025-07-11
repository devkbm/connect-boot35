package com.like.core.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 2960443107859013336L;

	String userId;
	String userName;
	String password;
	Collection<? extends GrantedAuthority> authorities;	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {		
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userId;
	}
	
	public String getUserName() {
		return this.userName;
	}

}
