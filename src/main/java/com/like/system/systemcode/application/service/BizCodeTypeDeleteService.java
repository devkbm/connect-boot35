package com.like.system.systemcode.application.service;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.application.port.in.delete.BizCodeTypeDeleteUseCase;
import com.like.system.systemcode.application.port.out.BizCodeTypeCommandDbPort;

@Service
public class BizCodeTypeDeleteService implements BizCodeTypeDeleteUseCase {

	BizCodeTypeCommandDbPort port;
	
	BizCodeTypeDeleteService(BizCodeTypeCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String typeId) {
		this.port.delete(companyCode, typeId);		
	}
	
	
}
