package com.like.system.systemcode.application.port.in.save;

import com.like.system.systemcode.domain.BizCodeType;
import com.like.system.systemcode.domain.BizTypeEnum;

public class BizCodeTypeSaveDTOMapper {

	public static BizCodeType toEntity(BizCodeTypeSaveDTO dto) {
		return new BizCodeType(dto.companyCode()
							  ,dto.typeId()
							  ,dto.typeName()
							  ,BizTypeEnum.valueOf(dto.bizType())
							  ,dto.comment());		
	}
	
	
}
