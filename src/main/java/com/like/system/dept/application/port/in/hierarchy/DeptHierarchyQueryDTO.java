package com.like.system.dept.application.port.in.hierarchy;

import jakarta.validation.constraints.NotEmpty;

public record DeptHierarchyQueryDTO(
		@NotEmpty(message="조직코드는 필수 입력 사항입니다.")
		String companyCode,
		String company,
		String deptCode,
		String deptName,
		Boolean isEnabled
		) {
	
	
	
}
