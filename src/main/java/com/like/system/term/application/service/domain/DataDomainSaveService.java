package com.like.system.term.application.service.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.application.dto.domain.DataDomainSaveDTO;
import com.like.system.term.application.dto.domain.DataDomainSaveDTOMapper;
import com.like.system.term.application.port.in.domain.DataDomainSaveUseCase;
import com.like.system.term.application.port.out.DataDomainCommandDbPort;

@Transactional
@Service
public class DataDomainSaveService implements DataDomainSaveUseCase {

	DataDomainCommandDbPort dbPort;
	
	DataDomainSaveService(DataDomainCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(DataDomainSaveDTO dto) {
		this.dbPort.save(DataDomainSaveDTOMapper.newEntity(dto));
	}

}
