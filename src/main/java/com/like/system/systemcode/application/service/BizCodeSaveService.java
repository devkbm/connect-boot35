package com.like.system.systemcode.application.service;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.application.port.in.save.BizCodeSaveDTO;
import com.like.system.systemcode.application.port.in.save.BizCodeSaveDTOMapper;
import com.like.system.systemcode.application.port.in.save.BizCodeSaveUseCase;
import com.like.system.systemcode.application.port.out.BizCodeCommandDbPort;
import com.like.system.systemcode.application.port.out.BizCodeTypeCommandDbPort;
import com.like.system.systemcode.domain.BizCodeType;

@Service
public class BizCodeSaveService implements BizCodeSaveUseCase {

	BizCodeCommandDbPort port;
	BizCodeTypeCommandDbPort bizCodeTypeDbPort;
	
	public BizCodeSaveService(BizCodeCommandDbPort port, BizCodeTypeCommandDbPort bizCodeTypeDbPort) {	
		this.port = port;
		this.bizCodeTypeDbPort = bizCodeTypeDbPort;
	}
	
	@Override
	public void save(BizCodeSaveDTO dto) {
		BizCodeType bizCodeType = this.bizCodeTypeDbPort.select(dto.companyCode(), dto.typeId()).orElse(null);
		this.port.save(BizCodeSaveDTOMapper.toEntity(dto, bizCodeType));
	}
	
}
