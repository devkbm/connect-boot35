package com.like.system.menu_role.application.service.role;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.role.select.RoleSelectDTO;
import com.like.system.menu_role.application.port.in.role.select.RoleSelectDTOMapper;
import com.like.system.menu_role.application.port.in.role.select.RoleSelectUseCase;
import com.like.system.menu_role.application.port.out.role.RoleCommandDbPort;

@Service
public class RoleSelectService implements RoleSelectUseCase {

	private RoleCommandDbPort port;
	
	public RoleSelectService(RoleCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public RoleSelectDTO select(String companyCode, String roleCode) { 
		return RoleSelectDTOMapper.toDTO(port.find(companyCode, roleCode).orElse(null));
	}

}
