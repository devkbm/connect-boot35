package com.like.hrm.overtime.domain.application.port.in.dto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record OverTimeApplicationFormDTO(
		String clientAppUrl,
		Long ovtmId,
		String companyCode,
		String staffNo,
		LocalDateTime from,
		LocalDateTime to,
		String contents,
		String location
		) {

}
