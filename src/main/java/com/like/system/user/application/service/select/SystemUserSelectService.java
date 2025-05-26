package com.like.system.user.application.service.select;

import org.springframework.stereotype.Service;

import com.like.system.user.application.dto.SystemUserSelectDTO;
import com.like.system.user.application.dto.SystemUserSelectDTOMapper;
import com.like.system.user.application.port.in.SystemUserSelectUseCase;
import com.like.system.user.application.port.out.SystemUserCommandDbPort;

@Service
public class SystemUserSelectService implements SystemUserSelectUseCase {

	SystemUserCommandDbPort dbPort;
	
	SystemUserSelectService(SystemUserCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}	

	@Override
	public SystemUserSelectDTO selectDTO(String userId, String companyCode) {
		return SystemUserSelectDTOMapper.toDTO(this.dbPort.select(userId), companyCode);
	}
}
