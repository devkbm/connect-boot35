package com.like.system.systemcode.application.port.in;

import com.like.system.systemcode.application.dto.BizCodeSaveDTO;

public interface BizCodeSelectUseCase {
	BizCodeSaveDTO select(String companyCode, String typeId, String code);	
}
