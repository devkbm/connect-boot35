package com.like.system.term.application.dto.term;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record TermSaveDTO(
		String companyCode,
		String clientAppUrl,
		String termId,
		String system,
		@NotEmpty(message = "용어는 필수 입력 값입니다.")
		List<String> term,
		String termEng,
		String columnName,
		String dataDomainId,
		String dataDomainName,
		String description,
		String comment
		) {
	
}