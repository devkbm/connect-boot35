package com.like.system.term.application.service.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.term.application.dto.domain.DataDomainSaveDTO;
import com.like.system.term.application.dto.domain.DataDomainSaveDTOMapper;
import com.like.system.term.application.port.in.domain.DataDomainQueryUseCase;
import com.like.system.term.application.port.out.DataDomainQueryDbPort;

@Service
public class DataDomainQueryService implements DataDomainQueryUseCase {

	DataDomainQueryDbPort dbPort;
	
	DataDomainQueryService(DataDomainQueryDbPort dbPort) {
		this.dbPort = dbPort;				
	}
	
	@Override
	public List<DataDomainSaveDTO> selectList() {
		return this.dbPort.select()
						  .stream()
						  .map(e -> DataDomainSaveDTOMapper.toDTO(e))
						  .toList();
	}

}
