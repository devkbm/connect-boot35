package com.like.system.menu_role.application.service.role;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.role.RoleSelectUseCase;
import com.like.system.menu_role.application.port.out.role.RoleCommandDbPort;
import com.like.system.menu_role.domain.role.Role;

@Service
public class RoleSelectService implements RoleSelectUseCase {

	private RoleCommandDbPort port;
	
	public RoleSelectService(RoleCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public Role select(String companyCode, String roleCode) { 
		return port.find(companyCode, roleCode);
	}

}
