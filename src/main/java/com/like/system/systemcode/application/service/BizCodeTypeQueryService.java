package com.like.system.systemcode.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.application.port.in.query.BizCodeTypeQueryResultDTO;
import com.like.system.systemcode.application.port.in.query.BizCodeTypeQueryUseCase;
import com.like.system.systemcode.application.port.out.BizCodeTypeQueryPort;

@Service
public class BizCodeTypeQueryService implements BizCodeTypeQueryUseCase {

	BizCodeTypeQueryPort port;
	
	public BizCodeTypeQueryService(BizCodeTypeQueryPort port) {
		this.port = port;
	}

	@Override
	public List<BizCodeTypeQueryResultDTO> select(String companyCode) {
		return this.port.select(companyCode);
	}
	
}
