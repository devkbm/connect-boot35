package com.like.hrm.overtime.domain.application.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.overtime.domain.application.port.in.OverTimeApplicationDeleteUseCase;
import com.like.hrm.overtime.domain.application.port.out.OverTimeApplicationCommandDbPort;

@Service
public class OverTimeApplicationDeleteService implements OverTimeApplicationDeleteUseCase {

	OverTimeApplicationCommandDbPort dbPort;
	
	OverTimeApplicationDeleteService(OverTimeApplicationCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);		
	}

}
