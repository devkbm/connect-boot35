package com.like.cooperation.team.domain.port.in.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record TeamMemberSaveDTO(
		@NotEmpty(message = "팅 ID는 필수 입력 값입니다.")
		Long teamId,
		@NotEmpty(message = "유저 ID는 필수 입력 값입니다.")
		String userId,
		String authority
		) {	
}