package com.like.system.user.application.port.in.query;

import jakarta.validation.constraints.NotBlank;

public record SystemUserQueryDTO(
		@NotBlank(message="조직 코드를 선택해주세요.")
		String companyCode,
		String userId,			
		String name,
		String deptCode
		) {

}
