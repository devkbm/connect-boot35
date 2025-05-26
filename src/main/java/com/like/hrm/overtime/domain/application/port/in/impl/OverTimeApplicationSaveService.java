package com.like.hrm.overtime.domain.application.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.overtime.domain.application.OverTimeApplication;
import com.like.hrm.overtime.domain.application.port.in.OverTimeApplicationSaveUseCase;
import com.like.hrm.overtime.domain.application.port.in.dto.OverTimeApplicationFormDTO;
import com.like.hrm.overtime.domain.application.port.in.dto.OverTimeApplicationFormDTOMapper;
import com.like.hrm.overtime.domain.application.port.out.OverTimeApplicationCommandDbPort;

@Service
public class OverTimeApplicationSaveService implements OverTimeApplicationSaveUseCase {

	OverTimeApplicationCommandDbPort dbPort;
	
	OverTimeApplicationSaveService(OverTimeApplicationCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(OverTimeApplicationFormDTO dto) {		
		OverTimeApplication entity = null;
		
		if (dto.ovtmId() == null) {
			entity = OverTimeApplicationFormDTOMapper.newEntity(dto);
		} else {
			entity = this.findEntity(dto.ovtmId());
			
			OverTimeApplicationFormDTOMapper.modifyEntity(entity, dto);
		}

		dbPort.save(entity);
	}
	
	private OverTimeApplication findEntity(Long id) {
		if (id == null) return null;
		
		return this.dbPort.select(id).orElse(null);
	}

}
