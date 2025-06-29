package com.like.system.systemcode.application.service;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.application.port.in.select.BizCodeTypeSelectDTO;
import com.like.system.systemcode.application.port.in.select.BizCodeTypeSelectDTOMapper;
import com.like.system.systemcode.application.port.in.select.BizCodeTypeSelectUseCase;
import com.like.system.systemcode.application.port.out.BizCodeTypeCommandDbPort;

@Service
public class BizCodeTypeSelectService implements BizCodeTypeSelectUseCase {

	BizCodeTypeCommandDbPort port;
	
	public BizCodeTypeSelectService(BizCodeTypeCommandDbPort port) {
		this.port = port;
	}

	@Override
	public BizCodeTypeSelectDTO select(String companyCode, String typeId) {
		return BizCodeTypeSelectDTOMapper.toDTO(this.port.select(companyCode, typeId).orElse(null));
	}
	
}
