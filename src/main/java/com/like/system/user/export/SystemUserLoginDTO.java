package com.like.system.user.export;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Builder;

@Builder
public record SystemUserLoginDTO(
		String companyCode,	
		String staffNo,		
		Collection<? extends GrantedAuthority> authorities
		) {
}
