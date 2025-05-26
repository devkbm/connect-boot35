package com.like.system.user.application.service.profile;

import org.springframework.stereotype.Service;

import com.like.system.user.application.dto.SystemUserProfileSelectDTO;
import com.like.system.user.application.dto.SystemUserProfileSelectDTOMapper;
import com.like.system.user.application.dto.SystemUserProfileSelectSessionDTO;
import com.like.system.user.application.port.in.SystemUserProfileSelectUseCase;
import com.like.system.user.application.port.out.SystemUserCommandDbPort;
import com.like.system.user.domain.SystemUser;

@Service
public class SystemUserProfileSelectService implements SystemUserProfileSelectUseCase {

	SystemUserCommandDbPort dbPort;	
	
	SystemUserProfileSelectService(SystemUserCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public SystemUserProfileSelectDTO select(String companyCode, String userId, SystemUserProfileSelectSessionDTO dto) {
		
		SystemUser entity = dbPort.select(userId);
								
		return SystemUserProfileSelectDTOMapper.toDTO(entity, dto);
	}

}
