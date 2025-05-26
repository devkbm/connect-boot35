package com.like.system.systemcode.application.service;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.application.dto.BizCodeSaveDTO;
import com.like.system.systemcode.application.port.in.BizCodeSelectUseCase;
import com.like.system.systemcode.application.port.out.BizCodeCommandDbPort;

@Service
public class BizCodeSelectService implements BizCodeSelectUseCase {
	
	BizCodeCommandDbPort port;
	
	public BizCodeSelectService(BizCodeCommandDbPort port) {		
		this.port = port;
	}
	
	@Override
	public BizCodeSaveDTO select(String companyCode, String typeId, String code) {						
		return this.port.selectDTO(companyCode, typeId, code);
	}
	
}
