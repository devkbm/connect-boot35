package com.like.system.systemcode.application.service;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.application.port.in.select.BizCodeSelectDTO;
import com.like.system.systemcode.application.port.in.select.BizCodeSelectDTOMapper;
import com.like.system.systemcode.application.port.in.select.BizCodeSelectUseCase;
import com.like.system.systemcode.application.port.out.BizCodeCommandDbPort;

@Service
public class BizCodeSelectService implements BizCodeSelectUseCase {
	
	BizCodeCommandDbPort port;
	
	public BizCodeSelectService(BizCodeCommandDbPort port) {		
		this.port = port;
	}
	
	@Override
	public BizCodeSelectDTO select(String companyCode, String typeId, String code) {						
		return BizCodeSelectDTOMapper.toDTO(this.port.select(companyCode, typeId, code).orElse(null));
	}
	
}
