package com.like.system.user.export;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.user.application.port.out.SystemUserCommandDbPort;

@Service
public class SystemUserDTOSelectService implements SystemUserDTOSelectUseCase {

	SystemUserCommandDbPort dbPort;
	
	SystemUserDTOSelectService(SystemUserCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public SystemUserDTO findUser(String userId, String companyCode) {
		return SystemUserDTOMapper.toDTO(this.dbPort.select(userId).orElse(null), companyCode);
	}

	
	@Override
	public List<SystemUserDTO> findUsers(List<String> userId, String companyCode) {
		
		return this.dbPort.select(userId)
						  .stream()
						  .map(e -> SystemUserDTOMapper.toDTO(e, companyCode))
						  .toList();
						  
	}	

}
