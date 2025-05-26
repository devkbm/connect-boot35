package com.like.system.systemcode.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.application.dto.BizCodeTypeSaveDTO;
import com.like.system.systemcode.application.port.in.BizCodeTypeQuerylUseCase;
import com.like.system.systemcode.application.port.out.BizCodeTypeQueryPort;

@Service
public class BizCodeTypeQueryService implements BizCodeTypeQuerylUseCase {

	BizCodeTypeQueryPort port;
	
	public BizCodeTypeQueryService(BizCodeTypeQueryPort port) {
		this.port = port;
	}

	@Override
	public List<BizCodeTypeSaveDTO> select(String companyCode) {
		return this.port.select(companyCode);
	}
	
}
