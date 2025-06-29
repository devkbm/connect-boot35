package com.like.system.systemcode.application.port.in.select;

public interface BizCodeSelectUseCase {
	BizCodeSelectDTO select(String companyCode, String typeId, String code);	
}
