package com.like.system.menu_role.application.service.role;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.menu_role.application.port.in.role.query.RoleQueryDTO;
import com.like.system.menu_role.application.port.in.role.query.RoleQueryResultDTO;
import com.like.system.menu_role.application.port.in.role.query.RoleQueryUseCase;
import com.like.system.menu_role.application.port.out.role.RoleQueryDbPort;

@Transactional(readOnly = true)
@Service
public class RoleQueryService implements RoleQueryUseCase {

	private RoleQueryDbPort port;
	
	public RoleQueryService(RoleQueryDbPort port) {
		this.port = port;
	}
		
	@Override
	public List<RoleQueryResultDTO> getList(RoleQueryDTO condition) {
		return port.getRoleList(condition);
	}

}
