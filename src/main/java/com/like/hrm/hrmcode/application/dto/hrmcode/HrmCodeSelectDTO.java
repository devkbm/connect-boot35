package com.like.hrm.hrmcode.application.dto.hrmcode;

import java.util.Map;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PUBLIC)
public record HrmCodeSelectDTO(
		String companyCode,
		String clientAppUrl,
		String typeId,
		String code,
		String codeName,
		boolean useYn,
		Integer sequence,
		String comment,
		Map<String, Object> extraInfo,
		String fieldConfig
		) {
	
}
