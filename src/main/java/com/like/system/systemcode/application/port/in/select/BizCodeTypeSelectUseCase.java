package com.like.system.systemcode.application.port.in.select;

public interface BizCodeTypeSelectUseCase {
	
	BizCodeTypeSelectDTO select(String companyCode, String typeId);
}
