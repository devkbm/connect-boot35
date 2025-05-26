package com.like.hrm.payitem.application.dto.payitem;

import lombok.Builder;

@Builder
public record PayItemFormDTO(
		String companyCode,
		String itemCode,
		String itemName,
		String type,
		Boolean usePayTable,
		Integer seq,
		String comment
		) {
}
