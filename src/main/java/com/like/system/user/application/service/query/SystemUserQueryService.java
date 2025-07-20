package com.like.system.user.application.service.query;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.user.application.port.in.query.SystemUserQueryDTO;
import com.like.system.user.application.port.in.query.SystemUserQueryResultDTO;
import com.like.system.user.application.port.in.query.SystemUserQueryUseCase;
import com.like.system.user.application.port.out.SystemUserQueryDbPort;

@Transactional(readOnly = true)
@Service
public class SystemUserQueryService implements SystemUserQueryUseCase {

	SystemUserQueryDbPort dbPort;
	
	SystemUserQueryService(SystemUserQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}	

	@Override
	public List<SystemUserQueryResultDTO> selectList(SystemUserQueryDTO dto) {		
		return this.dbPort.selectList(dto);
	}

}
