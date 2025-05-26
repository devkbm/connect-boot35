package com.like.system.systemcode.application.service;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.application.dto.BizCodeTypeSaveDTO;
import com.like.system.systemcode.application.port.in.BizCodeTypeSelectUseCase;
import com.like.system.systemcode.application.port.out.BizCodeTypeCommandDbPort;

@Service
public class BizCodeTypeSelectService implements BizCodeTypeSelectUseCase {

	BizCodeTypeCommandDbPort port;
	
	public BizCodeTypeSelectService(BizCodeTypeCommandDbPort port) {
		this.port = port;
	}

	@Override
	public BizCodeTypeSaveDTO select(String companyCode, String typeId) {
		return this.port.selectDTO(companyCode, typeId);
	}
	
}
