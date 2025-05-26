package com.like.system.term.application.service.term;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.application.dto.term.TermSaveDTO;
import com.like.system.term.application.dto.term.TermSaveDTOMapper;
import com.like.system.term.application.port.in.term.TermSelectUseCase;
import com.like.system.term.application.port.out.TermCommandDbPort;

@Transactional
@Service
public class TermSelectService implements TermSelectUseCase {

	TermCommandDbPort dbPort;
	
	TermSelectService(TermCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public TermSaveDTO select(String id) {
		return TermSaveDTOMapper.toDTO(this.dbPort.select(id));
	}

}
