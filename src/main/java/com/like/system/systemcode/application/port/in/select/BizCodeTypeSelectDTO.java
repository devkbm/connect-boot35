package com.like.system.systemcode.application.port.in.select;

import lombok.Builder;

@Builder
public record BizCodeTypeSelectDTO(
		String clientAppUrl,
		String companyCode,
		String typeId,			
		String typeName,			
		Integer sequence,
		String bizType,
		String comment
		) {

}
