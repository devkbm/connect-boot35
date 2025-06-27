package com.like.system.user.application.port.in.select;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record SystemUserSelectDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,
		String userId,
		@NotBlank(message="조직코드를 선택해 주세요.")
		String companyCode,
		@NotBlank(message="직원번호를 입력해 주세요.")
		String staffNo,
		String name,
		String deptCode,
		String deptName,
		String mobileNum,
		String email,
		String imageBase64,
		Boolean accountNonExpired,
		Boolean accountNonLocked,
		Boolean credentialsNonExpired,
		Boolean enabled,
		List<String> roleList,
		List<String> menuGroupList
		) {		
}
