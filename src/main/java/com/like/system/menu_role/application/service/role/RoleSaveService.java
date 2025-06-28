package com.like.system.menu_role.application.service.role;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.menu_role.application.port.in.role.save.RoleSaveDTO;
import com.like.system.menu_role.application.port.in.role.save.RoleSaveDTOMapper;
import com.like.system.menu_role.application.port.in.role.save.RoleSaveUseCase;
import com.like.system.menu_role.application.port.out.role.RoleCommandDbPort;
import com.like.system.menu_role.domain.role.Role;

@Transactional
@Service
public class RoleSaveService implements RoleSaveUseCase {

	RoleCommandDbPort dbPort;	
	
	public RoleSaveService(RoleCommandDbPort dbPort) {
		this.dbPort = dbPort;		
	}
	
	@Override
	public boolean exists(String companyCode, String roleCode) {
		return this.dbPort.exists(companyCode, roleCode);
	}

	@Override
	public void save(RoleSaveDTO dto) {
		Role entity = dbPort.find(dto.companyCode(), dto.roleCode()).orElse(null);			
		
		if (entity == null) {
			entity = RoleSaveDTOMapper.newEntity(dto);
		} else {
			RoleSaveDTOMapper.modifyEntity(entity, dto);			
		}
		
		dbPort.save(entity);		
	}

	
	
}
