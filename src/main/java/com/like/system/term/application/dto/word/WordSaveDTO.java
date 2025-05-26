package com.like.system.term.application.dto.word;

import lombok.Builder;

@Builder
public record WordSaveDTO(
		String companyCode,
		String clientAppUrl,
		String logicalName,
		String logicalNameEng,
		String physicalName,
		String comment
		) {	
}