package com.like.system.user.application.service.query;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.user.application.port.in.query.SystemUserQueryDTO;
import com.like.system.user.application.port.in.query.SystemUserQueryResultDTO;
import com.like.system.user.application.port.in.query.SystemUserQueryResultDTO2;
import com.like.system.user.application.port.in.query.SystemUserQueryResultDTOMapper;
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
		return this.dbPort.selectList(dto)
						  .stream()
						  .map(e -> SystemUserQueryResultDTOMapper.toDTO(e, dto.companyCode()))
						  .toList();
	}

	@Override
	public List<SystemUserQueryResultDTO2> selectList2(SystemUserQueryDTO dto) {
		
		return this.dbPort.selectList2(dto);
	}

}
