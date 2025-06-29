package com.like.system.systemcode.application.port.in.select;

import com.like.system.systemcode.domain.BizCodeType;

public class BizCodeTypeSelectDTOMapper {
	
	public static BizCodeTypeSelectDTO toDTO(BizCodeType entity) {
		if (entity == null) return null;
		
		return BizCodeTypeSelectDTO
				.builder()
				.companyCode(entity.getId().getCompanyCode())
				.typeId(entity.getId().getTypeId())
				.typeName(entity.getName())
				.sequence(entity.getSequence())
				.bizType(entity.getBizType().toString())
				.comment(entity.getComment())
				.build();
				
	}
	
}
