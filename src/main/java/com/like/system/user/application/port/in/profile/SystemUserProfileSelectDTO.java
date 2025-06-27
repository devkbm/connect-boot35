package com.like.system.user.application.port.in.profile;

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
