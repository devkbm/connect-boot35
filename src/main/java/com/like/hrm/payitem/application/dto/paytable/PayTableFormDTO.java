package com.like.hrm.payitem.application.dto.paytable;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record PayTableFormDTO(
		String id,
		String companyCode,
		String payItemCode,
		String occupationCode,
		String jobGradeCode,
		String payStepCode,
		BigDecimal wageAmount,
		Boolean isEnable,
		String comment
		) {

}
