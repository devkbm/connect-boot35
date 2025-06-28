package com.like.system.user.export;

import org.springframework.stereotype.Service;

import com.like.system.user.application.port.out.SystemUserCommandDbPort;

@Service
public class SystemUserLoginDTOSelectService implements SystemUserLoginDTOSelectUseCase {

	SystemUserCommandDbPort dbPort;
	
	SystemUserLoginDTOSelectService(SystemUserCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public SystemUserLoginDTO get(String staffNo, String companyCode) {
		return SystemUserLoginDTOMapper.toDTO(dbPort.select(staffNo).orElse(null), companyCode);
	}

}
