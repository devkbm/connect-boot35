package com.like.system.systemcode.application.service;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.application.port.in.save.BizCodeTypeSaveDTO;
import com.like.system.systemcode.application.port.in.save.BizCodeTypeSaveDTOMapper;
import com.like.system.systemcode.application.port.in.save.BizCodeTypeSaveUseCase;
import com.like.system.systemcode.application.port.out.BizCodeTypeCommandDbPort;

@Service
public class BizCodeTypeSaveService implements BizCodeTypeSaveUseCase {
	BizCodeTypeCommandDbPort port;

	public BizCodeTypeSaveService(BizCodeTypeCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void save(BizCodeTypeSaveDTO dto) {
		this.port.Save(BizCodeTypeSaveDTOMapper.toEntity(dto));		
	}
}
