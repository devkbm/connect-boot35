package com.like.system.user.application.dto;

import lombok.Builder;

@Builder
public record SystemUserProfileSelectDTO(
		String companyCode,
		String userId,
		String staffNo,
		String staffName,
		String deptCode,
		String deptName,
		String mobileNum,
		String email,		
		SystemUserProfileSelectSessionDTO session
		) {	
}
