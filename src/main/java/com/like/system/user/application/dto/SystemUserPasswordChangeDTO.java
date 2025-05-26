package com.like.system.user.application.dto;

public record SystemUserPasswordChangeDTO(
		String companyCode,
		String userId,
		String beforePassword,
		String afterPassword
		) {	
}