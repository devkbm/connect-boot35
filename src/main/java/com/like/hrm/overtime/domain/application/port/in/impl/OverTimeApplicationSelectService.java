package com.like.hrm.overtime.domain.application.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.overtime.domain.application.port.in.OverTimeApplicationSelectUseCase;
import com.like.hrm.overtime.domain.application.port.in.dto.OverTimeApplicationFormDTO;
import com.like.hrm.overtime.domain.application.port.in.dto.OverTimeApplicationFormDTOMapper;
import com.like.hrm.overtime.domain.application.port.out.OverTimeApplicationCommandDbPort;

@Service
public class OverTimeApplicationSelectService implements OverTimeApplicationSelectUseCase {

	OverTimeApplicationCommandDbPort dbPort;
	
	OverTimeApplicationSelectService(OverTimeApplicationCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public OverTimeApplicationFormDTO select(Long id) {
		
		return OverTimeApplicationFormDTOMapper.toDTO(this.dbPort.select(id).orElse(null));
	}

}
