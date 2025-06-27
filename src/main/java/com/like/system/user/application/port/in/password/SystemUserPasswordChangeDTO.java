package com.like.system.user.application.port.in.password;

public record SystemUserPasswordChangeDTO(
		String clientAppUrl,
		String companyCode,
		String userId,
		String beforePassword,
		String afterPassword
		) {	
}